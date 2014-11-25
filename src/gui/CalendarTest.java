package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class CalendarTest extends JPanel {

		// TODO Auto-generated constructor stub
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("EEE dd/MM");
		private static JLabel lblMan, lblTir, lblOns, lblTor, lblFre, lblLor, lblSon, lblMonth = new JLabel();
		private static GregorianCalendar calendar = new GregorianCalendar();
		private static int currentDay, currentMonth, currentDayWeek, currentDato, currentYear, daysPerMonth;
		private JTable table;

		public CalendarTest() {
			setLayout(null);
			
			// Get calendar set to current date and time
			//Calendar c = Calendar.getInstance();

			// Set the calendar to monday of the current week
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			// Print dates of the current week starting on Monday
			//DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
			/*for (int i = 0; i < 7; i++) {
			    System.out.println(df.format(c.getTime()));
			    c.add(Calendar.DATE, 1);
			}*/
			
		
			
			int realDay, realMonth, realYear, realWeek;
			final int realDayOfWeek;

		        
		        //GregorianCalendar calendar = new GregorianCalendar();
			realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);
			realMonth = calendar.get(GregorianCalendar.MONTH);
			realYear = calendar.get(GregorianCalendar.YEAR);
			realWeek = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
			realDayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
			
			/*System.out.println(realDay);
			System.out.println(realDayOfWeek);
			System.out.println(realWeek);
			System.out.println(realMonth);
			System.out.println(realYear);
			*/
			currentDay = realDay;
			currentMonth = realMonth;
			currentYear = realYear;
			daysPerMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			currentDayWeek = realDayOfWeek;
			currentDato = currentDay - currentDayWeek;
			System.out.println(calendar.getTime());			
			

			JButton btnNewButton = new JButton("Load");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calendar c = Calendar.getInstance();
					c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
					
					lblMan.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);

					lblTir.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblOns.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblTor.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblFre.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblLor.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblSon.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
				
				}
			});
			
			btnNewButton.setBounds(187, 218, 64, 23);
			add(btnNewButton);

			
			lblTir = new JLabel();
			lblTir.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblTir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblTir.setBackground(Color.WHITE);
			lblTir.setBounds(37, 96, 60, 23);
			add(lblTir);

			lblOns = new JLabel();
			lblOns.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblOns.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblOns.setBounds(107, 96, 54, 23);
			add(lblOns);

			lblTor = new JLabel();
			lblTor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblTor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTor.setBounds(177, 96, 54, 23);
			add(lblTor);
			
			lblFre = new JLabel();
			lblFre.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFre.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblFre.setBounds(244, 96, 54, 23);
			add(lblFre);

			lblLor = new JLabel();
			lblLor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblLor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblLor.setBounds(314, 96, 54, 23);
			add(lblLor);

			lblSon = new JLabel();
			lblSon.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblSon.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblSon.setBounds(384, 96, 54, 23);
			add(lblSon);

			lblMan = new JLabel();
			lblMan.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblMan.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblMan.setBounds(454, 96, 54, 23);
			add(lblMan);
			
		
			
			JButton btnNewButton_1 = new JButton("Previous Week");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.add(Calendar.DATE, -1);
					lblSon.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblLor.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblFre.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblTor.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblOns.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblTir.setText(df.format(c.getTime()));
					
					c.add(Calendar.DATE, -1);
					lblMan.setText(df.format(c.getTime()));
				}
			});
			btnNewButton_1.setBounds(53, 218, 124, 23);
			add(btnNewButton_1);
			
			lblMonth = new JLabel("Month");
			lblMonth.setBounds(83, 257, 50, 14);
			add(lblMonth);
			
			JButton btnNextWeek = new JButton("Next Week");
			btnNextWeek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblMan.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblTir.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblOns.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblTor.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblFre.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblLor.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					lblSon.setText(df.format(c.getTime()));
					c.add(Calendar.DATE, 1);
					
					/*for (int i = 0; i < 7; i++) {
					    System.out.println(df.format(c.getTime()));
					    c.add(Calendar.DATE, 1);
					}*/
					
				}
			});
			btnNextWeek.setBounds(261, 218, 124, 23);
			add(btnNextWeek);
			
			
			
			
			
		}
		
		
		public void wh(int month, int dato){
			
			int m  = month;
			int n = dato;
			int max = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			//max = 30dage i m�ned(septemper)
			//int a = 1;
			// i = 1->7, m=10
			
					
					//max = 30dage i m�ned
					
					//int x = currentDay - currentDayWeek +1;
					//int o = 0;
					// x=24
					//String a = String.valueOf(m);
					//lblMonth.setText(a);
					//a=10
					//cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
					//System.out.println(a);
					//System.out.println(max);
					/*int t = n+i;
					System.out.println(t);
					if(t <= max) { 
						 o = 1;
					}
					else if (t > max){
						System.out.println("not ok" +i);
						update(i, (currentMonth+1), 0);
						
						 o = 2;
					}*/
			int caseID = 0;
			while( n < max && caseID < 7 ) {
				n++;		
				caseID++;
		        System.out.println(n + " " + caseID);	         
		         update(caseID, n, m );
		         
		         }
			if( n == max)
				n = 0;
			while (n < max && caseID < 7 ) {
				n++;
				caseID++;
				System.out.println(caseID + " " + n);
				
				update(caseID,n, (m+1));
			}
				//update(caseID,1);
			
			
		}
		public void update(int caseID, int dato, int month) {
			int m = month;
			
			int i = caseID;
			int t = dato;
				
			switch(i) {
			
			case 1:
				lblMan.setText("Son" + (t + "/" + m));		
			case 2:
				lblTir.setText("Man" + (t + "/" + m));
			case 3:
				lblOns.setText("Tir" + (t + "/" + m));
			case 4:
				lblTor.setText("Ons" + (t + "/" + m));	
			case 5:
				lblFre.setText("Tor" + (t + "/" + m));
			case 6:
				lblLor.setText("Fre" + (t + "/" + m));
			case 7:
				lblSon.setText("Lor" + (t + "/" + m));
				
			

			      
			
			
			
			}
			
			
		}
	
	}


