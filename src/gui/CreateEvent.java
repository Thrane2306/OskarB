package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logic.Switch;

public class CreateEvent {
	private JTextField tFname;
	private JTextField tFdesc;
	private JTextField tFLoc;
	private JLabel lblMsg, lblName, lblDesc, lblLoc;
	@SuppressWarnings("rawtypes")
	private JComboBox comboStartYear, comboStartMonth, comboStartDay, comboStartH, comboStartM, comboEndM, comboEndH;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JButton btnCancel;
	private JButton btnCreate;

	public CreateEvent() {
		final JFrame eventFrame = new JFrame("New Event");
		eventFrame.setAlwaysOnTop(true);
		eventFrame.setBackground(Color.WHITE);
		eventFrame.setResizable(false);
		eventFrame.setVisible(true);
		eventFrame.setLocationRelativeTo(CalendarPanel.bullseye);
		eventFrame.setSize(400, 300);
		
		JPanel eventPanel = new JPanel();
		eventPanel.setBackground(Color.WHITE);
		eventFrame.getContentPane().add(eventPanel);
		eventPanel.setSize(400,300);
		eventPanel.setVisible(true);
		eventPanel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 83, 24);
		eventPanel.add(lblName);
		
		lblDesc = new JLabel("Description");
		lblDesc.setBounds(10, 46, 83, 24);
		eventPanel.add(lblDesc);
		
		lblLoc = new JLabel("Location");
		lblLoc.setBounds(10, 81, 83, 24);
		eventPanel.add(lblLoc);
		
		tFname = new JTextField();
		tFname.setBounds(119, 13, 255, 20);
		eventPanel.add(tFname);
		tFname.setColumns(10);
		
		tFdesc = new JTextField();
		tFdesc.setBounds(119, 48, 255, 20);
		eventPanel.add(tFdesc);
		tFdesc.setColumns(10);
		
		tFLoc = new JTextField();
		tFLoc.setBounds(119, 83, 255, 20);
		eventPanel.add(tFLoc);
		tFLoc.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblDate.setBounds(10, 116, 87, 25);
		eventPanel.add(lblDate);
		
		comboStartYear = new JComboBox();
		comboStartYear.setBounds(119, 116, 77, 27);
		comboStartYear.addItem("Year");
		comboStartYear.addItem("2014");
		comboStartYear.addItem("2015");
		comboStartYear.addItem("2016");
		eventPanel.add(comboStartYear);
		
		comboStartMonth = new JComboBox();
		comboStartMonth.setBounds(210, 116, 77, 27);
		comboStartMonth.addItem("Month");
		for (int i = 1; i < 13; i++) {
			comboStartMonth.addItem(i);
		}
		eventPanel.add(comboStartMonth);
		
		comboStartDay = new JComboBox();
		comboStartDay.addItem("Day");
		for (int i = 1; i < 32; i++) {
			comboStartDay.addItem(i);
		}

		comboStartDay.setBounds(297, 116, 77, 27);
		eventPanel.add(comboStartDay);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(10, 160, 87, 16);
		eventPanel.add(lblStart);
		
		comboStartH = new JComboBox();
		comboStartH.setBounds(119, 155, 113, 27);
		comboStartH.addItem("Hour");
		for (int i = 8; i < 23; i++) {
			comboStartH.addItem(i);
		}
		eventPanel.add(comboStartH);
		
		comboStartM = new JComboBox();
		comboStartM.setBounds(257, 155, 117, 27);
		comboStartM.addItem("Minute");
		for (int i = 0; i < 60; i++) {
			comboStartM.addItem(i);
		}
		eventPanel.add(comboStartM);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(10, 193, 100, 16);
		eventPanel.add(lblEnd);
		
		comboEndH = new JComboBox();
		comboEndH.setBounds(119, 188, 113, 27);
		comboEndH.addItem("Hour");
		for (int i = 8; i < 23; i++) {
			comboEndH.addItem(i);
		}
		eventPanel.add(comboEndH);
		
		comboEndM = new JComboBox();
		comboEndM.setBounds(257, 188, 117, 27);
		comboEndM.addItem("Minute");
		for (int i = 0; i < 60; i++) {
			comboEndM.addItem(i);
		}
		eventPanel.add(comboEndM);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventFrame.dispose();
			}
		});
		btnCancel.setBounds(119, 238, 89, 23);
		eventPanel.add(btnCancel);
		
		lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(164, 218, 173, 20);
		eventPanel.add(lblMsg);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringStartYear = "\"" + comboStartYear.getSelectedItem().toString()+ "\"";
				String stringStartMonth = "\"" + comboStartMonth.getSelectedItem().toString() + "\"";
				String stringStartDay = "\"" + comboStartDay.getSelectedItem().toString() + "\"";
				String stringStartTimeH = "\"" + comboStartH.getSelectedItem().toString() + "\"";
				String stringStartTimeM = "\"" + comboStartM.getSelectedItem().toString() + "\"";
				
				ArrayList<String> start = new ArrayList<String>();
				start.add(stringStartYear);
				start.add(stringStartMonth);
				start.add(stringStartDay);
				start.add(stringStartTimeH);
				start.add(stringStartTimeM);
				
				String stringEndYear = "\"" + comboStartYear.getSelectedItem().toString() + "\"";
				String stringEndMonth = "\"" + comboStartMonth.getSelectedItem().toString() + "\"";
				String stringEndDay = "\"" + comboStartDay.getSelectedItem().toString() + "\"";
				String stringEndTimeH = "\"" + comboEndH.getSelectedItem().toString() + "\"";
				String stringEndTimeM = "\"" + comboEndM.getSelectedItem().toString() + "\"";
				
				ArrayList<String> end = new ArrayList<String>();
				end.add(stringEndYear);
				end.add(stringEndMonth);
				end.add(stringEndDay);
				end.add(stringEndTimeH);
				end.add(stringEndTimeM);
				
				String name = tFname.getText();
				String desc =tFdesc.getText();
				String loc = tFLoc.getText();
				
				try {
					String answer = Switch.createEvent(loc, CalendarLogin.currentUser.getUsername(), start, end, desc, name);
					if (answer.equals("0")) {
						eventFrame.dispose();
					} else if (answer.equals("1")) {
						lblMsg.setText("Could not add event, please check date.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		btnCreate.setBounds(285, 238, 89, 23);
		eventPanel.add(btnCreate);
		
		
	}
}
