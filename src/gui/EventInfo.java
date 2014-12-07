package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import logic.Switch;

public class EventInfo {
	private JTextField eventName;
	private JTextField location;
	private JTextField eventId;
	private JTextPane txtpnNote;
	private JLabel lblMsg;

	public EventInfo(String name, String loc, String id, String note) {

		final JFrame eventInfo = new JFrame();
		eventInfo.setVisible(true);
		eventInfo.setTitle("Event Info");
		eventInfo.setLocationRelativeTo(CalendarPanel.bullseye);
		eventInfo.setSize(400, 300);

		JPanel infoPanel = new JPanel();
		eventInfo.getContentPane().add(infoPanel);
		infoPanel.setSize(400, 300);
		infoPanel.setVisible(true);
		infoPanel.setLayout(null);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventInfo.dispose();
			}
		});
		btnCancel.setBounds(134, 231, 107, 29);
		infoPanel.add(btnCancel);

		JLabel lblEventName = new JLabel("Event Name: ");
		lblEventName.setBounds(17, 20, 117, 16);
		infoPanel.add(lblEventName);

		JLabel lblEventDescription = new JLabel("Event Location: ");
		lblEventDescription.setBounds(17, 48, 117, 16);
		infoPanel.add(lblEventDescription);

		JLabel lblEventNote = new JLabel("Event Note:");
		lblEventNote.setBounds(17, 108, 117, 16);
		infoPanel.add(lblEventNote);

		eventName = new JTextField();
		eventName.setEditable(false);
		eventName.setBounds(146, 14, 215, 28);
		infoPanel.add(eventName);
		eventName.setText(name);
		eventName.setColumns(10);

		location = new JTextField();
		location.setEditable(false);
		location.setBounds(146, 42, 215, 28);
		infoPanel.add(location);
		location.setText(loc);
		location.setColumns(10);

		txtpnNote = new JTextPane();
		txtpnNote.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtpnNote.setText(note);
		txtpnNote.setBounds(146, 108, 215, 83);
		infoPanel.add(txtpnNote);

		JLabel lblEventID = new JLabel("Event ID: ");
		lblEventID.setBounds(17, 76, 117, 16);
		infoPanel.add(lblEventID);

		eventId = new JTextField();
		eventId.setBounds(146, 72, 215, 28);
		eventId.setText(id);
		infoPanel.add(eventId);
		eventId.setColumns(10);

		lblMsg = new JLabel("");
		lblMsg.setBounds(146, 204, 215, 16);
		infoPanel.add(lblMsg);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eventid = eventId.getText();
				String note = txtpnNote.getText();
				if (eventid.length() > 11) {
					lblMsg.setText("Can't set notes for CBS Events.");
				} else {
					try {
						String answer = Switch.switchMethod("saveNote",
								eventid, note);
						System.out.println(answer);
						if (answer.equals("0")) {
							lblMsg.setText("Note updated!");
							Thread.sleep(1000);
							eventInfo.dispose();
						} else if (answer.equals("1")) {
							lblMsg.setText("Note added!");
							Thread.sleep(1000);
							eventInfo.dispose();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSave.setBounds(267, 231, 107, 29);
		infoPanel.add(btnSave);

		JButton delEvent = new JButton("Delete event");
		delEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eventid = eventId.getText();
				try {
					String answer = Switch.switchMethod("deleteEvent", eventid,
							"");
					if (answer.equals("0")) {
						@SuppressWarnings("unused")
						CBSTEST change = new CBSTEST(CalendarLogin.currentUser
								.getUsername());
						eventInfo.dispose();
					} else if (answer.equals("1")) {
						lblMsg.setText("Couldn't delete event.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delEvent.setBounds(17, 231, 107, 29);
		infoPanel.add(delEvent);
	}
}
