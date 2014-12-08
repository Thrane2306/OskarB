package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
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
				
						lblMsg = new JLabel("");
						lblMsg.setBounds(533, 564, 225, 28);
						add(lblMsg);
		
				btnCreate = new CalBut();
				btnCreate.setText("Create");
				btnCreate.setBounds(527, 500, 150, 70);
				add(btnCreate);
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

		JLabel lblSignUp = new JLabel("Sign up!");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblSignUp.setBounds(503, 20, 400, 100);
		add(lblSignUp);

		JLabel lblUser = new JLabel("Username:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(503, 290, 124, 30);
		add(lblUser);

		JLabel lblPW = new JLabel("Password:");
		lblPW.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPW.setBounds(503, 360, 124, 30);
		add(lblPW);

		JLabel lblPWRepeat = new JLabel("Repeat password:");
		lblPWRepeat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPWRepeat.setBounds(503, 430, 200, 30);
		add(lblPWRepeat);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CalendarLogin.class.getResource("/gui/images/10807359_10204460222859850_1008122537_o.jpg")));
		lblNewLabel_1.setBounds(0, 257, 1193, 900);
		add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(503, 320, 200, 30);
		add(textField);
		textField.setColumns(10);

		PWField = new JPasswordField();
		PWField.setBounds(503, 390, 200, 30);
		add(PWField);

		PWField2 = new JPasswordField();
		PWField2.setBounds(503, 460, 200, 30);
		add(PWField2);

		btnBack = new CalBut();
		btnBack.setText("Back");
		btnBack.setBounds(10, 0, 150, 70);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				lblMsg.setText("");
				MyFrame.GUI.show(MyFrame.card, "calLog");
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
