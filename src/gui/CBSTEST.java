package gui;

import java.util.ArrayList;

import logic.Event;
import logic.Events;
import logic.Switch;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CBSTEST {
	
	private static String info, info2;
	private static ArrayList<String> info3, info4;
	
	
	public CBSTEST() {
	String overallID, cbsID, pik;
	overallID = "getCalendar";
	cbsID = "anli12ae";
	pik = "pik";
	System.out.println(pik);
	
	try {
		String answer = Switch.switchMethod(overallID, cbsID, pik);
		System.out.println("her");
		JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(answer).getAsJsonObject();
        Gson gson = new Gson();
        Events events = gson.fromJson(obj, Events.class);
		
        ArrayList<Event> calendarData = events.getEvents();
        
        for (Event event : calendarData) {
			 info = event.getDescription();
			 info2 = event.getType();
			 info3 = event.getStart();
			 info4 = event.getEnd();
			//System.out.println(event.getStart());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}


}
