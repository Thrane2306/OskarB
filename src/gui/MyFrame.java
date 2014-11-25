package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



import java.awt.Color;
import java.awt.CardLayout;

public class MyFrame extends JFrame {
	public final static Dimension SIZE = new Dimension(1207,940);
	public static JPanel card = new JPanel();
	public static CardLayout GUI;
	

	public MyFrame() {
		// TODO Auto-generated constructor stub
		
		
		
		
		
		setTitle("CBS Calendar");
		setSize(SIZE);
		getContentPane().setLayout(new CardLayout(0, 0));
		card.setLayout(GUI = new CardLayout());
		
		CalendarPanel calPal = new CalendarPanel();
	
		card.add("calPal", calPal);
		GUI.show(card, "calPal");
		getContentPane().add(card);
		setVisible(true);
		
		
}
}
