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

public class CalendarLogin extends JPanel{
	private JTextField textField;
	private JPasswordField passwordField;
	public CalendarLogin() {
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(12, 13, 1168, 887);
		add(panel);
		panel.setLayout(null);
				
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(528, 224, 150, 16);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(528, 259, 150, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(528, 294, 150, 16);
		panel.add(lblPassword);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFrame.GUI.show(MyFrame.card, ("calPal"));
			}
		});
		btnOk.setBounds(550, 379, 97, 25);
		panel.add(btnOk);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(528, 323, 150, 22);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CalendarLogin.class.getResource("/gui/CBS logo.png")));
		lblNewLabel.setBounds(324, 27, 646, 198);
		panel.add(lblNewLabel);
		
	}
}