package logic;

import shared.Push;
import gui.MyFrame;

import java.util.Scanner;

public class Switch {
	public static String switchMethod(String choose, String arg1, String arg2) throws Exception {
		String overallID, calendarName, userName, email, password, json, cbsID, answer = null;

		switch (choose) {
		case "createCalendar":
			overallID = "createCalendar";
			System.out.println("Enter calendar name: ");
			calendarName = arg1;
			System.out.println("Enter username: ");
			userName = arg2;
			json = "{\"serialVersionUID\":1,\"overallID\":\"" + overallID
					+ "\",\"calendarName\":\"" + calendarName
					+ "\",\"userName\":\"" + userName
					+ "\",\"publicOrPrivate\":1}";
			System.out.println(json);
			answer = Push.push(json);
			break;

		case "deleteCalendar":
			overallID = "deleteCalendar";
			System.out.println("Enter calendar name: ");
			calendarName = arg1;
			System.out.println("Enter username: ");
			userName = arg2;
			json = "{\"serialVersionUID\":1,\"overallID\":\"" + overallID
					+ "\",\"calendarName\":\"" + calendarName
					+ "\",\"userName\":\"" + userName
					+ "\",\"publicOrPrivate\":1}";
			System.out.println(json);
			answer = Push.push(json);
			break;

		case "logIn":
			overallID = "logIn";
			email = arg1;
			password = arg2;
			answer = Push.push(JSONStrings.login(overallID, email, password));
			break;
		
		case "getCalendar":
			overallID = "getCalendar";
			cbsID = arg1;
			answer = Push.push(JSONStrings.getCalendar(overallID, cbsID));
		}
		
		return answer;
	}
}
