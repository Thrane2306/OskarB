package gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CalendarPanel extends JPanel {
	public static JPanel panelOpt, panel, cT, panelDate;
	@SuppressWarnings("unused")
	private JButton btnSettings;

	static Calendar c = Calendar.getInstance();
	static DateFormat df = new SimpleDateFormat("EEE dd/MM");
	static DateFormat current = new SimpleDateFormat("YYYY-MM-dd");
	@SuppressWarnings("unused")
	private static JLabel lblMonth, lblMandag, lblOns, lblMan, lblTir, lblTor,
			lblFre, lblLor, lblSon, lblToday, lblQuote, lblWeatherIcon;

	@SuppressWarnings("unused")
	private JTable table;
	private static String result, result1, result2;
	private static String currentDate;
	private static JTextArea textAreaToday, textAreaNext;
	static JLabel[] Eventlbls, label;
	private static CalBut nxtWeek, prevWeek, btnnewEvent, btnLogout;
	static JLabel bullseye;
	private JLabel lblNewLabel;

	public CalendarPanel() {
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);
		currentDate = current.format(c.getTime());
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.get(Calendar.WEEK_OF_YEAR);

		panelOpt = new JPanel();
		panelOpt.setForeground(Color.BLACK);
		panelOpt.setBackground(Color.WHITE);
		panelOpt.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOpt.setBounds(8, 13, 211, 677);
		add(panelOpt);
		panelOpt.setLayout(null);

		lblToday = new JLabel("Weather Today");
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblToday.setBounds(10, 11, 200, 45);
		panelOpt.add(lblToday);

		lblWeatherIcon = new JLabel("");
		lblWeatherIcon.setBounds(137, 75, 64, 53);
		panelOpt.add(lblWeatherIcon);

		textAreaToday = new JTextArea();
		textAreaToday.setEditable(false);
		textAreaToday.setBounds(10, 45, 200, 246);
		panelOpt.add(textAreaToday);

		JLabel lblNextFour = new JLabel("Weather for the next 4 days");
		lblNextFour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNextFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextFour.setBounds(10, 302, 200, 33);
		panelOpt.add(lblNextFour);

		textAreaNext = new JTextArea();
		textAreaNext.setEditable(false);
		textAreaNext.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textAreaNext.setBounds(10, 346, 200, 320);
		panelOpt.add(textAreaNext);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.WHITE);
		panel.setBounds(8, 690, 1160, 210);
		add(panel);

		btnLogout = new CalBut();
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarLogin.currentUser.setUsername(null);
				c = Calendar.getInstance();
				MyFrame.calLog.reset();
				MyFrame.GUI.show(MyFrame.card, "calLog");
			}
		});
		btnLogout.setText("Logout");
		btnLogout.setBounds(980, 11, 150, 70);
		panel.add(btnLogout);

		btnnewEvent = new CalBut();
		btnnewEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateEvent newEvent = new CreateEvent();
			}
		});
		btnnewEvent.setText("Create Event");
		btnnewEvent.setBounds(660, 11, 150, 70);
		panel.add(btnnewEvent);

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

		lblMan = new JLabel();
		lblMan.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblMan.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMan.setBounds(0, 54, 119, 36);
		panelDate.add(lblMan);

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

		nxtWeek = new CalBut();
		nxtWeek.setText("Next week");
		nxtWeek.setBounds(500, 11, 270, 36);
		panelDate.add(nxtWeek);

		prevWeek = new CalBut();
		prevWeek.setText("Previous");
		prevWeek.setBounds(10, 11, 270, 36);
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

		bullseye = new JLabel("");
		bullseye.setBounds(357, 29, 46, 14);
		panelDate.add(bullseye);
		c.add(Calendar.DATE, 1);

		lblNewLabel = new JLabel("<html>" + "8:00" + "<br><br>" + "9:00"
				+ "<br><br>" + "10:00" + "<br><br>" + "11:00" + "<br><br>"
				+ "12:00" + "<br><br>" + "13:00" + "<br><br>" + "14:00"
				+ "<br><br>" + "15:00" + "<br><br>" + "16:00" + "<br><br>"
				+ "17:00" + "<br><br>" + "18:00" + "<br><br>" + "19:00"
				+ "<br<br>" + "20:00" + "<br><br>" + "21:00" + "<br><br>"
				+ "22:00");
		lblNewLabel.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(229, 180, 73, 510);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CalendarLogin.class.getResource("/gui/images/10807359_10204460222859850_1008122537_o.jpg")));
		lblNewLabel_1.setBounds(0, 257, 1193, 900);
		add(lblNewLabel_1);

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
				c.get(Calendar.WEEK_OF_YEAR);
				CBSTEST preWeek = new CBSTEST(CalendarLogin.currentUser
						.getUsername());
			}
		});

		nxtWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.get(Calendar.WEEK_OF_YEAR);
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

				CBSTEST nextWeek = new CBSTEST(CalendarLogin.currentUser
						.getUsername());

			}
		});

		CBSTEST load = new CBSTEST(CalendarLogin.currentUser.getUsername());
		WeatherTest weather = new WeatherTest();
		String QOTD = null;
		try {
			QOTD = Switch.switchMethod("getQuote", null, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		lblQuote = new JLabel("");
		lblQuote.setFocusable(false);
		lblQuote.setText("\"" + QOTD + "\"");
		lblQuote.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblQuote.setBounds(10, 142, 1140, 44);
		panel.add(lblQuote);
	}

	public static void drawBorders() {

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

	static void load(String desc, String type, ArrayList<String> start,
			ArrayList<String> end, String loc, String id) {

		String string = lblMan.getText();

		DateFormat originalFormat = new SimpleDateFormat("EE dd/MM");
		DateFormat targetFormat = new SimpleDateFormat("w");
		Date date;
		try {
			date = originalFormat.parse(string);
			result = targetFormat.format(date);
		} catch (ParseException e) {
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
		try {
			date1 = orgFormatter.parse(dateInString);
			result2 = tarFor2.format(date1);
			result1 = tarFormat.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int counter = 0;
		if (result.equals(result1)) {

			counter++;

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

			setLabels(1, 1, width, height, desc, weekDay, counter, sH, type,
					sM, eH, eM, loc, id);

		}

	}

	public static void setLabels(int x, int y, int w, int h, String desc,
			int weekDay, int c, int sT, String type, int sM, int eT, int eM,
			String loc, String id) {
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
		String sSM = String.format("%02d", sM);
		String sEM = String.format("%02d", eM);
		int starttidmin = (sT * 60) + sM;
		float as = starttidmin - 480;
		float ad = as / 840;
		float e = ad * 502 + 74;
		int d = Math.round(e);

		Eventlbls = new JLabel[30];
		for (int i = 0; i < c; i++)
			Eventlbls[i] = new JLabel();
		Eventlbls[0].setBounds(10, 64, 119, 60);
		for (int i = 0; i < c; i++) {

			final String arg1 = desc;
			final String arg2 = type;
			final String nid = id;

			Eventlbls[i].setBounds(dayP, d, w, h);
			Eventlbls[i].setOpaque(true);
			Eventlbls[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			Eventlbls[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						System.out.println("mouseclicked" + nid);
						String note = Switch.switchMethod("getNote", nid, "");
						System.out.println("fik note");
						System.out.println(note);
						@SuppressWarnings("unused")
						EventInfo infoframe = new EventInfo(arg1, arg2, nid,
								note);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});

			if (desc.contains("Makro")) {
				Eventlbls[i].setBackground(new Color(0, 255, 0));

			} else if (desc.contains("Virksomhedens")) {
				Eventlbls[i].setBackground(new Color(102, 102, 255));
			} else if (desc
					.contains("Ledelse af IS - forandring, innovation og viden")) {
				Eventlbls[i].setBackground(new Color(255, 102, 255));
			} else if (desc.contains("systemer")) {
				Eventlbls[i].setBackground(new Color(255, 153, 51));
			} else {
				Eventlbls[i].setBackground(Color.YELLOW);
			}
			Eventlbls[i].setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			Eventlbls[i].setText("<html>" + desc + "<br>" + sT + ":" + sSM
					+ "-" + eT + ":" + sEM + "@" + loc);

			cT.add(Eventlbls[i]);

			cT.repaint();
		}

	}

	public static void weatherLoad(String date, String desc, String celsius,
			int c) throws ParseException {
		SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dato = new SimpleDateFormat("dd/MM");
		Date dtime = original.parse(date);
		String stime = time.format(dtime);
		String sdato = dato.format(dtime);
		String image = null;

		if (date.contains(currentDate) && c == 0) {
			if (desc.contains("sky")) {
				image = "sun.png";
			} else if (desc.contains("clouds")) {
				image = "cloud.png";
			} else if (desc.contains("rain")) {
				image = "rain.png";
			} else if (desc.contains("snow")) {
				image = "snow.png";
			} else if (desc.contains("mist")) {
				image = "mist.png";
			} else {
				image = "thunder.png";
			}
			textAreaToday
					.append("\nRight now:\n" + celsius + " C° \n" + "\n\n");
			lblWeatherIcon.setIcon(new ImageIcon(CalendarPanel.class
					.getResource("/gui/images/" + image)));
		} else if (date.contains(currentDate) && c < 3) {
			textAreaToday.append(stime + "\n" + celsius + " C° \n" + desc
					+ "\n\n");
		} else if (!date.contains(currentDate) && date.contains("12:00:00")) {
			textAreaNext.append("\n\n" + sdato + "\n" + celsius + " C° \n"
					+ desc);

		}

	}
}
