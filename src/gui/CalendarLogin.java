package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
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
	private static JLabel lblLogStatus;

	public CalendarLogin() {
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 1193, 900);
		add(panel);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(503, 290, 124, 30);
		panel.add(lblUsername);

		userTextField = new JTextField();
		userTextField.setBounds(503, 320, 200, 30);
		panel.add(userTextField);
		userTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(503, 360, 124, 30);
		panel.add(lblPassword);

		CalBut butOk = new CalBut();
		butOk.setBounds(528, 440, 150, 50);
		panel.add(butOk);
		butOk.setText("OK");
		butOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login();
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(503, 390, 200, 30);
		panel.add(passwordField);

		lblLogStatus = new JLabel("");
		lblLogStatus.setBounds(528, 525, 150, 14);
		panel.add(lblLogStatus);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CalendarLogin.class
				.getResource("/gui/images/CBS logo.png")));
		lblNewLabel.setBounds(327, -13, 646, 278);
		panel.add(lblNewLabel);

		//JButton butnewUser = new JButton("New user?");
		CalBut butNewUser = new CalBut();
		butNewUser.setBounds(528, 490, 150, 50);
		butNewUser.setText("Sign up");
		panel.add(butNewUser);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CalendarLogin.class.getResource("/gui/images/10807359_10204460222859850_1008122537_o.jpg")));
		lblNewLabel_1.setBounds(0, 257, 1193, 900);
		panel.add(lblNewLabel_1);
		
		butNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLogStatus.setText("");
				MyFrame.GUI.show(MyFrame.card, "newUser");
			}
		});
		

	}

	public void Login() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		String username = userTextField.getText();
		char[] password = passwordField.getPassword();
		String passwordString = new String(password);

		try {
			answer = Switch.switchMethod("logIn", username, passwordString);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		switch (answer) {
		case "0":

			currentUser = new User();
			currentUser.setUsername(username);
			calPal = new CalendarPanel();
			reset();
			MyFrame.card.add("calPal", calPal);
			MyFrame.GUI.show(MyFrame.card, "calPal");
		case "1":
			reset();
			lblLogStatus.setText("Email not found!");
			break;
		case "2":
			reset();
			lblLogStatus.setText("User is inactive");
			break;
		case "3":
			reset();
			lblLogStatus.setText("Wrong password");
			break;
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	public void reset() {
		userTextField.setText("");
		passwordField.setText("");
		lblLogStatus.setText("");
	}
}
