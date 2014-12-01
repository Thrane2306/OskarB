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
import java.awt.Rectangle;

public class CalendarTest extends JPanel {

		// TODO Auto-generated constructor stub
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("EEE dd/MM");
		private static JLabel lblMan, lblTir, lblOns, lblTor, lblFre, lblLor, lblSon, lblMonth, lblMandag = new JLabel();
		private static GregorianCalendar calendar = new GregorianCalendar();
		private static int currentDay, currentMonth, currentDayWeek, currentDato, currentYear, daysPerMonth, a;
		private JTable table;
		private static String result, result1, result2;
		static JLabel[] totalAYearLabel;

		public CalendarTest() {
			super();
			setBounds(new Rectangle(0, 0, 856, 677));
			setBackground(Color.WHITE);
			setLayout(null);
			a = 0;
			
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
			loaBut.setBounds(244, 11, 270, 50);
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
			lblTir.setBounds(129, 117, 119, 36);
			add(lblTir);

			lblOns = new JLabel();
			lblOns.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblOns.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblOns.setBounds(248, 117, 119, 36);
			add(lblOns);

			lblTor = new JLabel();
			lblTor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblTor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTor.setBounds(367, 117, 119, 36);
			add(lblTor);
			
			lblFre = new JLabel();
			lblFre.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblFre.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblFre.setBounds(486, 117, 119, 36);
			add(lblFre);

			lblLor = new JLabel();
			lblLor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblLor.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblLor.setBounds(605, 117, 119, 36);
			add(lblLor);

			lblSon = new JLabel();
			lblSon.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblSon.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblSon.setBounds(724, 117, 119, 36);
			add(lblSon);

			lblMan = new JLabel();
			lblMan.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblMan.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblMan.setBounds(10, 117, 119, 36);
			add(lblMan);
			
		
			
			//JButton btnNewButton_1 = new JButton("Previous Week");
			CalBut prevWeek = new CalBut();
			prevWeek.setText("Previous");
			prevWeek.setBounds(10, 11, 270, 50);
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
			
			
			//JButton btnNextWeek = new JButton("Next Week");
			CalBut nxtWeek = new CalBut();
			nxtWeek.setText("Next week");
			nxtWeek.setBounds(500, 11, 270, 50);
			add(nxtWeek);
			nxtWeek.addActionListener(new ActionListener() {
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
			
			
			JLabel lblTirsdag = new JLabel("");
			lblTirsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTirsdag.setBounds(10, 164, 119, 502);
			add(lblTirsdag);
			
			JLabel lblOnsdag = new JLabel("");
			lblOnsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblOnsdag.setBounds(129, 164, 119, 502);
			add(lblOnsdag);
			
			JLabel lblTorsdag = new JLabel("");
			lblTorsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTorsdag.setBounds(248, 164, 119, 502);
			add(lblTorsdag);
			
			JLabel lblFredag = new JLabel("");
			lblFredag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblFredag.setBounds(367, 164, 119, 502);
			add(lblFredag);
			
			JLabel lblLordag = new JLabel("");
			lblLordag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblLordag.setBounds(486, 164, 119, 502);
			add(lblLordag);
			
			JLabel lblSondag = new JLabel("");
			lblSondag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblSondag.setBounds(605, 164, 119, 502);
			add(lblSondag);
			
			JLabel lblMandag = new JLabel("");
			lblMandag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblMandag.setBounds(724, 164, 119, 502);
			add(lblMandag);
			
			//JButton btnNewButton_2 = new JButton("Load lektioner");
			//CustomButton
			CalBut loadLek = new CalBut();
			loadLek.setText("Load classes");
			loadLek.setBounds(232, 44, 270, 50);
			add(loadLek);
			loadLek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CBSTEST input = new CBSTEST();
					
					
				}
			});
			
			
			
			
			
			
		}
		
		
		public void wh(int month, int dato){
			
			int m  = month;
			int n = dato;
			int max = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			//max = 30dage i mï¿½ned(septemper)
			//int a = 1;
			// i = 1->7, m=10
			
					
					//max = 30dage i mï¿½ned
					
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
		static void load(String desc, String type, ArrayList<String> start,
				ArrayList<String> end) {
			// format :[2014, 11, 20, 9, 50]
			/*
			 * String test0 = "2014"; String test1 = "11"; String test2 = "20";
			 */
			String string = lblMan.getText();
			a++;

			DateFormat originalFormat = new SimpleDateFormat("EE dd/MM");
			DateFormat targetFormat = new SimpleDateFormat("w");
			Date date;
			try {
				date = originalFormat.parse(string);
				result = targetFormat.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String listString = "";

			for (String s : start) {
				listString += s + " ";
			}
			SimpleDateFormat orgFormatter = new SimpleDateFormat("yyyy MM dd hh mm");
			SimpleDateFormat tarFormat = new SimpleDateFormat("w");
			SimpleDateFormat tarFor2 = new SimpleDateFormat("u");
			String dateInString = listString;
			Date date1;
			Date date2;
			try {
				date1 = orgFormatter.parse(dateInString);
				// date2 = orgFormatter.parse(dateInString);
				result2 = tarFor2.format(date1);
				result1 = tarFormat.format(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int c = 0;
			if (result.equals(result1)) {

				c++;
				// System.out.println("uge nr ok");

				// for (int v = 55; v <= 1; v += 25)

				// lblManLek1.setText(desc);
				// lblManLek1.setBackground(Color.PINK);
				Integer weekDay = Integer.valueOf(result2);
				Integer sH = Integer.valueOf(start.get(3));
				Integer sM = Integer.valueOf(start.get(4));
				Integer eH = Integer.valueOf(end.get(3));
				Integer eM = Integer.valueOf(end.get(4));
				String startTid = start.get(3) + start.get(4);
				Integer sT = Integer.valueOf(startTid);
				// Calculate Label height
				int tH = (eH - sH) * 60;
				int tTM = eM - sM;
				float total = tH + tTM;
				float delAfHeleDagen = (total / 840);
				float aP = 502 * delAfHeleDagen;
				int height = Math.round(aP);

				int width = 118;
				 //System.out.println(sT);
				setLabels(1, 1, width, height, desc, weekDay, c, sT, type);
				/*
				 * totalAYearLabel = new JLabel[30]; for (int i = 0; i < 30; i++)
				 * totalAYearLabel[i] = new JLabel();
				 * totalAYearLabel[0].setBounds(10, 130, 80, 14); for (int i = 0; i
				 * < 30; i++){
				 * 
				 * 
				 * totalAYearLabel[i].setBounds(10, 130, 80, a);
				 * totalAYearLabel[i].setOpaque(true);
				 * totalAYearLabel[i].setBackground(Color.PINK);
				 * totalAYearLabel[i].setText(desc);
				 * CalendarPanel.cT.add(totalAYearLabel[i]); //JLabel test = new
				 * JLabel("sdfdgffd"); //test.setBounds(100,100,500,500);
				 * CalendarPanel.cT.add(totalAYearLabel[i]);
				 * 
				 * 
				 * 
				 * CalendarPanel.cT.repaint();
				 */

				// lblManLek1.setBounds(10, 130, 80, a);

			}

		}

		public static void setLabels(int x, int y, int w, int h, String desc, int weekDay, int c, int sT, String type){
			 int dayP = 0;
			
				 if(weekDay==1){
					 dayP = 10;
				 }else if(weekDay==2){
					 dayP = 129;
				 	}else if(weekDay==3){
				 		dayP = 248;
				 		}else if(weekDay==4){
				 			dayP = 367;
				 			}else if(weekDay==5){
				 				dayP = 486;
				 				}else if(weekDay==6){
				 					dayP = 605;
				 					}else if(weekDay==7){
				 						dayP = 724;
									 }
									 else {
										 System.out.println("fail");
								 }
				 
				 float a = sT - 800;
				float b = a / 1400;
				float cc = b * 502 + 164;	 
				int d = Math.round(cc);	 
				
				 
					totalAYearLabel = new JLabel[30];
					for (int i = 0; i < c; i++)
							totalAYearLabel[i] = new JLabel();
						totalAYearLabel[0].setBounds(10, 64, 119, 60);
					for (int i = 0; i < c; i++){						

						 
				totalAYearLabel[i].setBounds(dayP, d, w, h);
				System.out.println(dayP + " " + d + " " +  w + " "+ h);
				totalAYearLabel[i].setOpaque(true);
				
				if(desc.contains("Makroøkonomi")){
					totalAYearLabel[i].setBackground(new Color(0, 255, 0));
					System.out.println("makro");
				 }else if(desc.contains("Virksomhedens økonomiske styring")){
					 totalAYearLabel[i].setBackground(new Color(102, 102, 255));
				 	}else if(desc.contains("Ledelse af IS - forandring, innovation og viden")){
				 		totalAYearLabel[i].setBackground(new Color(255, 102, 255));
				 		}else {	
				totalAYearLabel[i].setBackground(Color.WHITE);
				 		}
				totalAYearLabel[i].setFont(new Font("Lucida Grande", Font.PLAIN, 8));
				totalAYearLabel[i].setText("<html>" + desc
				         + "<br>" + type);
				CalendarPanel.cT.add(totalAYearLabel[i]);
				
				/*JLabel test = new JLabel("sdfdgffd");
				test.setBounds(100,100,500,500);
				CalendarPanel.cT.add(test);*/
				//System.out.println(desc + "\n" + type);
				
				
				
				CalendarPanel.cT.repaint();
				}
	}
	}


