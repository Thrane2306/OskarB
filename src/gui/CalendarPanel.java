package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;

import logic.Switch;

import javax.swing.JTextPane;

public class CalendarPanel extends JPanel {
	public static JPanel panelOpt, panel, cT, panelDate;
	//public static CalendarTest cT;
	private JButton btnSettings;
	
	private static Calendar c = Calendar.getInstance();
	static DateFormat df = new SimpleDateFormat("EEE dd/MM");
	private static JLabel lblMonth, lblMandag,lblOns, lblMan, lblTir, lblTor, lblFre, lblLor, lblSon = new JLabel();
	private static GregorianCalendar calendar = new GregorianCalendar();
	private static int currentDay, currentMonth, currentDayWeek, currentDato,
			currentYear, daysPerMonth, a;
	private JTable table;
	private static JTextPane textpane;
	private static String result, result1, result2;
	static JLabel[] totalAYearLabel;
	private static CalBut nxtWeek, prevWeek;
	

	public CalendarPanel() {
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);

		panelOpt = new JPanel();
		panelOpt.setForeground(Color.BLACK);
		panelOpt.setBackground(Color.WHITE);
		panelOpt.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOpt.setBounds(8, 13, 294, 677);
		add(panelOpt);
		panelOpt.setLayout(null);
		
		JLabel lblToday = new JLabel("Weather Today");
		lblToday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblToday.setBounds(72, 11, 142, 45);
		panelOpt.add(lblToday);
		
		textpane = new JTextPane();
		textpane.setBounds(10, 78, 274, 96);
		panelOpt.add(textpane);
		
		/*cT = new CalendarTest();
		cT.setBorder(new LineBorder(Color.BLACK));
		cT.setForeground(Color.BLACK);
		cT.setBounds(0, 0, 856, 677);
		panelCal.add(cT);*/
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.setBounds(8, 703, 1160, 197);
		add(panel);

		
		JLabel label = new JLabel("Quote of the day: ");
		label.setBounds(12, 40, 400, 101);
		panel.add(label);
		
		CalBut calBut = new CalBut();
		calBut.setText("Load Quote");
		calBut.setForeground(Color.WHITE);
		calBut.setBounds(-37, 0, 270, 50);
		panel.add(calBut);
		
		
		
		cT = new JPanel();
		cT.setBounds(new Rectangle(312, 114, 856, 576));
		cT.setBackground(Color.WHITE);
		cT.setLayout(null);
		add(cT);
		
		panelDate = new JPanel();
		panelDate.setBackground(Color.WHITE);
		panelDate.setBounds(312, 13, 833, 90);
		panelDate.setLayout(null);
		add(panelDate);
		
	

		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


		int realDay, realMonth, realYear, realWeek;
		final int realDayOfWeek;

		
		realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		realMonth = calendar.get(GregorianCalendar.MONTH);
		realYear = calendar.get(GregorianCalendar.YEAR);
		realWeek = calendar.get(GregorianCalendar.WEEK_OF_YEAR);
		realDayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
		currentDay = realDay;
		currentMonth = realMonth;
		currentYear = realYear;
		daysPerMonth = calendar
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		currentDayWeek = realDayOfWeek;
		currentDato = currentDay - currentDayWeek;
		System.out.println(calendar.getTime());
		
		
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		

		
		lblTir = new JLabel();
		lblTir.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblTir.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTir.setBackground(Color.WHITE);
		lblTir.setBounds(119, 54, 119, 36);
		panelDate.add(lblTir);

		lblOns = new JLabel();
		lblOns.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblOns.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOns.setBounds(238, 54, 119, 36);
		panelDate.add(lblOns);

		lblTor = new JLabel();
		lblTor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblTor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTor.setBounds(357, 54, 119, 36);
		panelDate.add(lblTor);
		
		lblFre = new JLabel();
		lblFre.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblFre.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFre.setBounds(476, 54, 119, 36);
		panelDate.add(lblFre);

		lblLor = new JLabel();
		lblLor.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblLor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLor.setBounds(595, 54, 119, 36);
		panelDate.add(lblLor);

		lblSon = new JLabel();
		lblSon.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblSon.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSon.setBounds(714, 54, 119, 36);
		panelDate.add(lblSon);

		lblMan = new JLabel();
		lblMan.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblMan.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMan.setBounds(0, 54, 119, 36);
		panelDate.add(lblMan);
		
		nxtWeek = new CalBut();
		nxtWeek.setText("Next week");
		nxtWeek.setBounds(500, 11, 270, 50);
		panelDate.add(nxtWeek);
	
		prevWeek = new CalBut();
		prevWeek.setText("Previous");
		prevWeek.setBounds(10, 11, 270, 50);
		panelDate.add(prevWeek);
		
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
		
		CBSTEST load = new CBSTEST(CalendarLogin.currentUser.getUsername());
		
		
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
				CBSTEST preWeek = new CBSTEST(CalendarLogin.currentUser.getUsername());
			}
		});

	
		
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

				CBSTEST nextWeek = new CBSTEST(CalendarLogin.currentUser.getUsername());

			}
		});
	}
		
public static void drawBorders(){
	
		
		
		JLabel lblTirsdag = new JLabel("");
		lblTirsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTirsdag.setBounds(0, 74, 119, 502);
		cT.add(lblTirsdag);

		JLabel lblOnsdag = new JLabel("");
		lblOnsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOnsdag.setBounds(119, 74, 119, 502);
		cT.add(lblOnsdag);

		JLabel lblTorsdag = new JLabel("");
		lblTorsdag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTorsdag.setBounds(238, 74, 119, 502);
		cT.add(lblTorsdag);

		JLabel lblFredag = new JLabel("");
		lblFredag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFredag.setBounds(357, 74, 119, 502);
		cT.add(lblFredag);

		JLabel lblLordag = new JLabel("");
		lblLordag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLordag.setBounds(476, 74, 119, 502);
		cT.add(lblLordag);

		JLabel lblSondag = new JLabel("");
		lblSondag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSondag.setBounds(595, 74, 119, 502);
		cT.add(lblSondag);

		JLabel lblMandag = new JLabel("");
		lblMandag.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMandag.setBounds(714, 74, 119, 502);
		cT.add(lblMandag);
		
		
		
		

	}

		static void weatherLoad(String date, String desc, String celsius, String qotd){
			
			textpane.setText(date + desc + celsius + qotd);
	
		}

	static void load(String desc, String type, ArrayList<String> start,
			ArrayList<String> end) {
		// format :[2014, 11, 20, 9, 50]
		/*
		 * String test0 = "2014"; String test1 = "11"; String test2 = "20";
		 */
		String string = lblMan.getText();
		//a++;

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
			
			setLabels(1, 1, width, height, desc, weekDay, c, sH, type, sM);


		}

	}

	public static void setLabels(int x, int y, int w, int h, String desc,
			int weekDay, int c, int sT, String type, int sM) {
		int dayP = 0;

		if (weekDay == 1) {
			dayP = 0;
		} else if (weekDay == 2) {
			dayP = 119;
		} else if (weekDay == 3) {
			dayP = 238;
		} else if (weekDay == 4) {
			dayP = 357;
		} else if (weekDay == 5) {
			dayP = 476;
		} else if (weekDay == 6) {
			dayP = 595;
		} else if (weekDay == 7) {
			dayP = 714;
		} else {
			System.out.println("fail");
		}
		
		int starttidmin = (sT * 60) + sM;
		float as = starttidmin - 480;
		float ad = as / 840;
		//float a = sT - 800;
		//float b = a / 1400;
		float e = ad * 502 + 74;
		int d = Math.round(e);
		System.out.println(ad);
		

		totalAYearLabel = new JLabel[30];
		for (int i = 0; i < c; i++)
			totalAYearLabel[i] = new JLabel();
		totalAYearLabel[0].setBounds(10, 64, 119, 60);
		for (int i = 0; i < c; i++) {

			totalAYearLabel[i].setBounds(dayP, d, w, h);
			System.out.println(dayP + " " + d + " " + w + " " + h);
			totalAYearLabel[i].setOpaque(true);

			if (desc.contains("Makroøkonomi")) {
				totalAYearLabel[i].setBackground(new Color(0, 255, 0));

			} else if (desc.contains("Virksomhedens økonomiske styring")) {
				totalAYearLabel[i].setBackground(new Color(102, 102, 255));
			} else if (desc
					.contains("Ledelse af IS - forandring, innovation og viden")) {
				totalAYearLabel[i].setBackground(new Color(255, 102, 255));
			} else {
				totalAYearLabel[i].setBackground(Color.lightGray);
			}
			totalAYearLabel[i]
					.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			totalAYearLabel[i].setText("<html>" + desc + "<br>" + type);
			
			cT.add(totalAYearLabel[i]);

			/*
			 * JLabel test = new JLabel("sdfdgffd");
			 * test.setBounds(100,100,500,500); CalendarPanel.cT.add(test);
			 */
			// System.out.println(desc + "\n" + type);

			cT.repaint();
		}
	



		//setVisible(true);

	
}
}
