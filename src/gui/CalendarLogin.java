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

public class CalendarLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

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

		textField = new JTextField();
		textField.setBounds(528, 328, 150, 22);
		panel.add(textField);
		textField.setColumns(10);

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
				MyFrame.GUI.show(MyFrame.card, ("calPal"));
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
}