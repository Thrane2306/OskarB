package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.CardLayout;

public class MyFrame extends JFrame {
	public final static Dimension SIZE = new Dimension(1207, 940);
	public static JPanel card = new JPanel();
	public static CardLayout GUI;
	public static CalendarLogin calLog;
	public static NewUser newUser;

	public MyFrame() {

		setTitle("CBS Calendar");
		setSize(SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		card.setLayout(GUI = new CardLayout());

		calLog = new CalendarLogin();
		newUser = new NewUser();

		card.add("newUser", newUser);
		card.add("calLog", calLog);
		GUI.show(card, "calLog");
		getContentPane().add(card);
		setVisible(true);

	}
}
