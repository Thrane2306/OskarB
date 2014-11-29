package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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
		private static String result, result1;

		public CalendarTest() {
			setBackground(Color.WHITE);
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
				
			CalBut loaBut = new CalBut();
			loaBut.setBounds(244, 11, 64, 23);
			add(loaBut);
			loaBut.setText("Load");
			loaBut.addActionListener(new ActionListener() {
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
			
			

			
			lblTir = new JLabel();
			lblTir.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblTir.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTir.setBackground(Color.WHITE);
			lblTir.setBounds(90, 96, 80, 23);
			add(lblTir);

			lblOns = new JLabel();
			lblOns.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblOns.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblOns.setBounds(170, 96, 80, 23);
			add(lblOns);

			lblTor = new JLabel();
			lblTor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblTor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTor.setBounds(250, 96, 80, 23);
			add(lblTor);
			
			lblFre = new JLabel();
			lblFre.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFre.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblFre.setBounds(330, 96, 80, 23);
			add(lblFre);

			lblLor = new JLabel();
			lblLor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblLor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblLor.setBounds(410, 96, 80, 23);
			add(lblLor);

			lblSon = new JLabel();
			lblSon.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblSon.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblSon.setBounds(490, 96, 80, 23);
			add(lblSon);

			lblMan = new JLabel();
			lblMan.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblMan.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblMan.setBounds(10, 96, 80, 23);
			add(lblMan);
			
		
			
			//JButton btnNewButton_1 = new JButton("Previous Week");
			CalBut prevWeek = new CalBut();
			prevWeek.setText("Previous");
			prevWeek.setBounds(10, 11, 124, 23);
			add(prevWeek);
			//btnNewButton_1.setBackground(new Color(255, 255, 255));
			prevWeek.addActionListener(new ActionListener() {
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
			btnNextWeek.setBounds(459, 11, 124, 23);
			add(btnNextWeek);
			
			JLabel lblTirsdag = new JLabel("");
			lblTirsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTirsdag.setBounds(10, 130, 80, 303);
			add(lblTirsdag);
			
			JLabel lblOnsdag = new JLabel("");
			lblOnsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblOnsdag.setBounds(90, 130, 80, 303);
			add(lblOnsdag);
			
			JLabel lblTorsdag = new JLabel("");
			lblTorsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTorsdag.setBounds(170, 130, 80, 303);
			add(lblTorsdag);
			
			JLabel lblFredag = new JLabel("");
			lblFredag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblFredag.setBounds(250, 130, 80, 303);
			add(lblFredag);
			
			JLabel lblLordag = new JLabel("");
			lblLordag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblLordag.setBounds(330, 130, 80, 303);
			add(lblLordag);
			
			JLabel lblSondag = new JLabel("");
			lblSondag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblSondag.setBounds(410, 130, 80, 303);
			add(lblSondag);
			
			JLabel lblMandag = new JLabel("");
			lblMandag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblMandag.setBounds(490, 130, 80, 303);
			add(lblMandag);
			
			JLabel lblManLek1 = new JLabel("");
			lblManLek1.setOpaque(true);
			lblManLek1.setBackground(Color.PINK);
			lblManLek1.setBounds(10, 130, 80, 14);
			add(lblManLek1);
			
			JLabel lblManLek2 = new JLabel("");
			lblManLek2.setOpaque(true);
			lblManLek2.setBackground(new Color(0, 0, 205));
			lblManLek2.setBounds(10, 155, 80, 14);
			add(lblManLek2);
			
			JLabel lblManLek3 = new JLabel("");
			lblManLek3.setBackground(Color.BLACK);
			lblManLek3.setOpaque(true);
			lblManLek3.setBounds(10, 172, 80, 14);
			add(lblManLek3);
			
			JLabel lblManLek4 = new JLabel("");
			lblManLek4.setBackground(Color.RED);
			lblManLek4.setOpaque(true);
			lblManLek4.setBounds(10, 198, 80, 14);
			add(lblManLek4);
			
			JButton btnNewButton_2 = new JButton("Load lektioner");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CBSTEST input = new CBSTEST();
					
					
				}
			});
			btnNewButton_2.setBounds(232, 44, 112, 23);
			add(btnNewButton_2);
			
			
			
			
			
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
		public static void load(String desc, String type, ArrayList<String> start, ArrayList<String> end) {
			// format  :[2014, 11, 20, 9, 50]
			/*String test0 = "2014";
			String test1 = "11"; 
			String test2 = "20";*/
			String string = lblMan.getText();
			
			
			DateFormat originalFormat = new SimpleDateFormat("EE dd/MM");
			DateFormat targetFormat = new SimpleDateFormat("2014" + " MM dd");
			Date date;
			try {
				date = originalFormat.parse(string);
				result = targetFormat.format(date);
				//System.out.println(formattedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			String listString = "";

			for (String s : start)
			{
			    listString += s + " ";
			}
			SimpleDateFormat orgFormatter = new SimpleDateFormat("yyyy MM dd hh mm");
			SimpleDateFormat tarFormat = new SimpleDateFormat("yyyy MM dd");
			String dateInString = listString;
			Date date1;
			try {
				date1 = orgFormatter.parse(dateInString);
				result1 = tarFormat.format(date1);
				//System.out.println(result);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result.equals(result1)){
				System.out.println("ok");
			}

			
		
			
			//System.out.println(desc + " " + type + " " + start + " " + end );
			
			
		}
	}


