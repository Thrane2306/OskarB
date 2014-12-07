package logic;

import java.util.ArrayList;

public class JSONStrings {
	public static String login(String overallID, String email, String password) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\"" + overallID
		+ "\",\"email\":\"" + email
		+ "\",\"password\":\"" + password
		+ "\",\"isAdmin\":true}";
		return json;
	}
	public static String getCalendar(String overallID, String cbsID) {
	String json = "{\"serialVersionUID\":1,\"overallID\":\"" + "getCalendar"
	+ "\",\"cbsID\":\"" + cbsID + "\"}";
	return json;
	}
	public static String getWeather() {
		
		String json = "{\"serialVersionUID\":1,\"overallID\":\"getWeather\"}";
				
		return json;
	}
	public static String createEvent(String location, String createdBy,
			ArrayList<String> start, ArrayList<String> end, String name,
			String text) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\"createEvent\",\"location\":\"" + location + 
				"\",\"createdby\":\"" + createdBy + "\",\"start\":" + start + ",\"end\":" + end + ",\"title\":\"" 
				+ name + "\",\"description\":\"" + text + "\"}";  
		System.out.println(json);
		return json;
		
	}
	public static String getQuote() {
		String json = "{\"overallID\":\"getQuote\"}";
		return json;
	}
	public static String addUser(String overallID, String email, String password) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\"" + overallID
				+ "\",\"email\":\"" + email + "\",\"password\":\"" + password
				+ "\"}";
		return json;
	}
	public static String getEventNote(String eventID) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\""
				+ "getNote" + "\",\"eventid\":\"" + eventID + "\"}";
		System.out.println(json);
		return json;
	}
	
	public static String saveEventNote(String eventID, String text) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\""
				+ "saveNote" + "\",\"eventid\":\"" + eventID + "\",\"note\":\"" + text + "\"}";
		return json;
	}
	public static String deleteEvent(String eventID) {
		String json = "{\"serialVersionUID\":1,\"overallID\":\""
				+ "deleteEvent" + "\",\"eventid\":\"" + eventID + "\"}";
		return json;
	}
}
