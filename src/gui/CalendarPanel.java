package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;

public class CalendarPanel extends JPanel {
	public static JPanel panelCal, panelOpt;
	private JButton btnSettings;

	public CalendarPanel() {
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);

		panelCal = new JPanel();
		panelCal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCal.setBounds(314, 13, 856, 677);
		add(panelCal);

		panelOpt = new JPanel();
		panelOpt.setForeground(Color.BLACK);
		panelOpt.setBackground(Color.WHITE);
		panelOpt.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOpt.setBounds(8, 13, 294, 677);
		add(panelOpt);
		panelOpt.setLayout(null);

		// btnSettings = new JButton("Settings");
		CalBut setBut = new CalBut();
		// but.setForeground(Color.BLACK);
		setBut.setBounds(12, 13, 270, 50);
		panelOpt.add(setBut);
		panelCal.setLayout(null);
		setBut.setText("Settings");
		CalendarTest cT = new CalendarTest();
		cT.setBorder(new LineBorder(Color.BLACK));
		cT.setForeground(Color.BLACK);
		cT.setBounds(0, 0, 856, 677);
		panelCal.add(cT);
		
		JPanel panel = new JPanel();
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

		setVisible(true);

	}
}
