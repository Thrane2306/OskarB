package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class CalendarProgram {
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext;
	static JTable tblCalendar;
	static JComboBox cmbYear;
	static JFrame frmMain;
	static Container pane;
	static DefaultTableModel mtblCalendar; //table model
	static JScrollPane stblCalendar; //the scrollpane
	static JPanel pnlCalendar;
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	private static JLabel lblQuoteOfThe;
	
	public static void main (String args[]){
		//look and feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
		//Prepare frame
		frmMain = new JFrame ("CBS Calendar"); //create frame
		frmMain.setSize(1207,940); //size of JFrame
		pane = frmMain.getContentPane(); //get content pane
		pane.setLayout(null); //apply null layout
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// means close when X is clicked
		
		//create controls
		lblMonth = new JLabel ("January"); //Month label
		lblYear = new JLabel ("Change year:"); //Change year label, only text
		cmbYear = new JComboBox(); //change year combo box
		btnPrev = new JButton("<<"); //Button to change to previous month
		btnNext = new JButton (">>");
		mtblCalendar = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex, int mColIndex){
				return false;}};
		tblCalendar = new JTable (mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);
		
		//set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Monthly"));
		
		//Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		
		//add controls to pane
		pane.add(pnlCalendar);
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(lblYear);
		pnlCalendar.add(cmbYear);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		
		//set bounds for calendar
		pnlCalendar.setBounds(242, 49, 959, 856); //set panel bounds
		lblMonth.setBounds(700, 20, 100, 25);
		lblYear.setBounds(770, 823, 80, 20); //"Change year:" placement
		cmbYear.setBounds(877, 823, 70, 20); //combo box placement
		btnPrev.setBounds(650, 20, 50, 25); //Previous month button
		btnNext.setBounds(897, 20, 50, 25); //Next month button
		stblCalendar.setBounds(12, 50, 935, 760);
		//Make frame visible
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		//get real month/year
		GregorianCalendar cal = new GregorianCalendar(); // creates calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //gets day
		realMonth = cal.get(GregorianCalendar.MONTH); // gets month
		realYear = cal.get(GregorianCalendar.YEAR); //Gets year
		currentMonth = realMonth; // matches month and year
		currentYear = realYear;
		
		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //all headers
		for (int i=0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
		}
		
		tblCalendar.getParent().setBackground(tblCalendar.getBackground());
		// set background
		
		//no resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);
		
		//single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//set row/column count
		tblCalendar.setRowHeight(120);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 59, 232, 800);
		frmMain.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("M\u00E5nedsvisning");
		btnNewButton.setBounds(0, 45, 220, 66);
		panel.add(btnNewButton);
		
		JButton btnDagsvisning = new JButton("Dagsvisning");
		btnDagsvisning.setBounds(0, 245, 220, 66);
		panel.add(btnDagsvisning);
		
		JButton btnIndstillinger = new JButton("Indstillinger");
		btnIndstillinger.setBounds(0, 445, 220, 66);
		panel.add(btnIndstillinger);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 1189, 31);
		frmMain.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblQuoteOfThe = new JLabel("Quote of the day:");
		lblQuoteOfThe.setBounds(0, 0, 121, 29);
		panel_1.add(lblQuoteOfThe);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);
		
		//populate table
		for (int i=realYear-100; i<=realYear+100; i++){
			cmbYear.addItem(String.valueOf(i));
			}
		
		//refresh calendar
		refreshCalendar (realMonth, realYear);
	}
		
			
		
	public static void refreshCalendar(int month, int year) {
		//variables
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som; //Nod=number of days som=start of month
		
		//allow disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= realYear-10){
			btnPrev.setEnabled(false);} // too early
		if (month == 11 && year >= realYear+100){
			btnNext.setEnabled(false);} //too late
		lblMonth.setText(months[month]); //Refresh the month label at the top
		lblMonth.setBounds(800-lblMonth.getPreferredSize().width/2, 20, 180, 25); // re-align label with calendar
		cmbYear.setSelectedItem(String.valueOf(year)); //select the correct year in the combo box
		
		//Clear table
		for (int i=0; i<6; i++){
			for (int j=0; j<7; j++){
				mtblCalendar.setValueAt(null, i, j);
			}
		}
		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		//Draw calendar
		for (int i=1; i<=nod; i++){
			int row = new Integer((i+som-2)/7);
			int column = (i+som-2)%7;
			mtblCalendar.setValueAt(i, row, column);		
			}
		
		//apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}
	
	static class tblCalendarRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6){ //week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //week
				setBackground(new Color (255, 255, 255));
			}
			if (value != null){
				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //today
					setBackground(new Color(220, 220, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}
	
	static class btnPrev_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 0){ //back one year
				currentMonth = 11;
				currentYear -= 1;
			}
			else{ // back one month
				currentMonth -= 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	
	static class btnNext_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentMonth == 11){ //forward one year
				currentMonth = 0;
				currentYear += 1;
			}
			else{ //forward one month
				currentMonth += 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	static class cmbYear_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (cmbYear.getSelectedItem() != null){
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}
}
				

