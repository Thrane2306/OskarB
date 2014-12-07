package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Switch;

public class NewUser extends JPanel {
	private JTextField textField;
	private JPasswordField PWField;
	private JPasswordField PWField2;
	private static String answer;
	static CalBut btnBack, btnCreate;
	static JLabel lblMsg;

	public NewUser() {

		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(10, 11, 124, 28);
		add(lblUser);

		JLabel lblPW = new JLabel("Password");
		lblPW.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPW.setBounds(10, 50, 124, 28);
		add(lblPW);

		JLabel lblPWRepeat = new JLabel("Repeat");
		lblPWRepeat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPWRepeat.setBounds(10, 89, 124, 28);
		add(lblPWRepeat);

		textField = new JTextField();
		textField.setBounds(240, 11, 200, 28);
		add(textField);
		textField.setColumns(10);

		PWField = new JPasswordField();
		PWField.setBounds(240, 50, 200, 28);
		add(PWField);

		PWField2 = new JPasswordField();
		PWField2.setBounds(240, 87, 200, 28);
		add(PWField2);

		btnBack = new CalBut();
		btnBack.setText("Back");
		btnBack.setBounds(10, 266, 89, 23);
		add(btnBack);

		btnCreate = new CalBut();
		btnCreate.setText("Create");
		btnCreate.setBounds(351, 266, 89, 23);
		add(btnCreate);

		lblMsg = new JLabel("");
		lblMsg.setBounds(215, 151, 225, 28);
		add(lblMsg);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				lblMsg.setText("");
				MyFrame.GUI.show(MyFrame.card, "calLog");
			}

		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = addUser();
				switch (a) {
				case 0:
					lblMsg.setText("Signup succesful!");
					clear();
					break;
				case 1:
					lblMsg.setText("Database error!");
					clear();
					break;
				case 2:
					lblMsg.setText("Username already exists.");
					clear();
					break;
				case 3:
					lblMsg.setText("Passwords don't match.");
					clear();
					break;
				}
			}
		});

	}

	public int addUser() {
		String username = textField.getText();
		char[] newpw = PWField.getPassword();
		char[] repeat = PWField2.getPassword();
		String repeatString = new String(repeat);
		String newpwString = new String(newpw);

		if (repeatString.equals(newpwString)) {
			try {
				answer = Switch.switchMethod("addUser", username, newpwString);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			switch (answer) {
			case "0":
				return 0;
			case "1":
				return 1;
			case "2":
				return 2;
			}
		}
		return 3;
	}

	public void clear() {
		PWField.setText("");
		textField.setText("");
		PWField2.setText("");
	}
}
