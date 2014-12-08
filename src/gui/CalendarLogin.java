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
import javax.swing.SwingConstants;

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
		lblUsername.setBounds(528, 299, 150, 16);
		panel.add(lblUsername);

		userTextField = new JTextField();
		userTextField.setBounds(528, 328, 150, 22);
		panel.add(userTextField);
		userTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(528, 363, 150, 22);
		panel.add(lblPassword);

		CalBut butOk = new CalBut();
		butOk.setBounds(528, 425, 150, 70);
		panel.add(butOk);
		butOk.setText("Login");
		butOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login();
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(528, 392, 150, 22);
		panel.add(passwordField);

		lblLogStatus = new JLabel("");
		lblLogStatus.setBounds(528, 525, 150, 14);
		panel.add(lblLogStatus);

		JButton butnewUser = new JButton("New user?");
		butnewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLogStatus.setText("");
				MyFrame.GUI.show(MyFrame.card, "newUser");
			}
		});
		butnewUser.setBounds(528, 550, 150, 23);
		panel.add(butnewUser);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblWelcome.setBounds(510, 165, 217, 123);
		panel.add(lblWelcome);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Morten\\Desktop\\background2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1193, 900);
		panel.add(lblNewLabel_1);

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
