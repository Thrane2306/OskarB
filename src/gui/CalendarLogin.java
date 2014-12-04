package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.JPasswordField;

import logic.Switch;
import logic.User;

public class CalendarLogin extends JPanel {
	public static CalendarPanel calPal;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private static String answer;
	public static User currentUser;
	//public static CalendarTest cT ;

	public CalendarLogin() {
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 1193, 900);
		add(panel);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(528, 299, 150, 16);
		panel.add(lblUsername);

		userTextField = new JTextField();
		userTextField.setBounds(528, 328, 150, 22);
		panel.add(userTextField);
		userTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(528, 363, 150, 16);
		panel.add(lblPassword);

		CalBut but = new CalBut();
		but.setBounds(528, 425, 150, 70);
		panel.add(but);
		but.setText("OK");
		// JButton btnOk = new JButton("OK");
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WeatherTest test = new WeatherTest();
					//System.out.println(answer);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Login();
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(528, 392, 150, 22);
		panel.add(passwordField);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CalendarLogin.class
				.getResource("/gui/CBS logo.png")));
		lblNewLabel.setBounds(327, -13, 646, 278);
		panel.add(lblNewLabel);

	}
	public void Login(){
		String username = userTextField.getText();
		char[] password = passwordField.getPassword();
		String passwordString = new String(password);

		try {
			answer = Switch.switchMethod("logIn", username,
					passwordString);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		switch (answer) {
		case "0":
			currentUser = new User();
			currentUser.setUsername(username);
			userTextField.setText("");
			passwordField.setText("");
			calPal = new CalendarPanel();
			
			/*cT = new CalendarTest();
			cT.setBorder(new LineBorder(Color.BLACK));
			cT.setForeground(Color.BLACK);
			cT.setBounds(0, 0, 856, 677);
			calPal.add(cT);*/
			MyFrame.card.add("calPal", calPal);
			MyFrame.GUI.show(MyFrame.card, "calPal");
		}
	}
	}
	
