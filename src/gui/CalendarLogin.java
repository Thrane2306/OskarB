package gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class CalendarLogin extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	public CalendarLogin() {
		setBounds(new Rectangle(0, 0, 1180, 900));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 1168, 887);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLogin.setBounds(528, 88, 150, 72);
		panel.add(lblLogin);
		
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(528, 331, 150, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFrame.GUI.show(MyFrame.card, ("calPal"));
			}
		});
		btnOk.setBounds(550, 379, 97, 25);
		panel.add(btnOk);
		
		
		
		
	
		
		}
	}