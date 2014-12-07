package logic;

import shared.Push;
import gui.MyFrame;

import java.util.ArrayList;
import java.util.Scanner;

public class Switch {
	public static String switchMethod(String choose, String arg1, String arg2) throws Exception {
		String overallID, calendarName, userName, email, password, note, json, cbsID, eventid, newpw, answer = null;

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
			
		case "addUser":
			overallID = "addUser";
			email = arg1;
			password = arg2;
			answer = Push.push(JSONStrings.addUser(overallID, email, password));
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
			break;
		case "getNote":
			eventid = arg1;
			answer = Push.push(JSONStrings.getEventNote(eventid));
			break;
		case "saveNote":
			eventid = arg1;
			note = arg2;
			answer = Push.push(JSONStrings.saveEventNote(eventid, note));
			break;
		case "getQuote":
			overallID = "getQuote";
			answer = Push.push(JSONStrings.getQuote());
			break;

		case "getWeather":
			answer = Push.push(JSONStrings.getWeather());
			break;
		
		}
		
		return answer;
	}

	public static String createEvent(String location, String createdBy,
			ArrayList<String> start, ArrayList<String> end, String name,
			String text) throws Exception{
		String answer = null;
		answer = Push.push(JSONStrings.createEvent(location, createdBy, start, end, name, text));
		return answer;
	}
}
