package gui;

import java.awt.Cursor;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CalBut extends JButton {

	public CalBut() {

		String rootPath = System.getProperty("user.dir");
		String imgPath = rootPath + File.separator + "res\\img"
				+ File.separator;
		ImageIcon image = new ImageIcon(imgPath + "knap1.jpg");
		ImageIcon image2 = new ImageIcon(imgPath + "knap2.jpg");
		setIcon(image);
		setRolloverIcon(image2);
		

		setCursor(new Cursor(Cursor.HAND_CURSOR));

		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setVerticalTextPosition(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
	}
	

}
