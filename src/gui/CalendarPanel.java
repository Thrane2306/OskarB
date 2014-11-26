package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;

public class CalendarPanel extends JPanel{
	public static JPanel panelCal, panelOpt;
	private JButton btnSettings;
	public CalendarPanel() {
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);
		
		
		
		panelCal = new JPanel();
		panelCal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCal.setBounds(314, 212, 856, 677);
		add(panelCal);
		
		panelOpt = new JPanel();
		panelOpt.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOpt.setBounds(10, 212, 294, 677);
		add(panelOpt);
		panelOpt.setLayout(null);
		
		btnSettings = new JButton("Settings");
		btnSettings.setBounds(12, 13, 270, 50);
		panelOpt.add(btnSettings);
		panelCal.setLayout(null);
		CalendarTest cT = new CalendarTest();
		cT.setBounds(10, 11, 836, 659);
		panelCal.add(cT);
		setVisible(true);
		
	}
	}


