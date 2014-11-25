package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;

public class CalendarPanel extends JPanel{
	public static JPanel panelCal, panelOpt;
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
		panelCal.setLayout(null);
		CalendarTest cT = new CalendarTest();
		cT.setBounds(10, 11, 836, 659);
		panelCal.add(cT);
		setVisible(true);
		
	}
	}


