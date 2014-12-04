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
	
	
	public CBSTEST(String UserId) {
	String overallID, cbsID, nothing;
	overallID = "getCalendar";
	cbsID = UserId;
	nothing = "";
	
	
	try {
		String answer = Switch.switchMethod(overallID, cbsID, nothing);
		System.out.println("her");
		JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(answer).getAsJsonObject();
        Gson gson = new Gson();
        Events events = gson.fromJson(obj, Events.class);
        CalendarPanel.cT.removeAll();
		
        ArrayList<Event> calendarData = events.getEvents();
        
        for (Event event : calendarData) {
        	
        	String Smonth =  event.getStart().get(1);
        	int newSmonth = Integer.valueOf(Smonth);
        	 event.getStart().set(1, "" + ++newSmonth);
        	 
        	 String Emonth =  event.getEnd().get(1);
         	int newEmonth = Integer.valueOf(Emonth);
         	 event.getEnd().set(1, "" + ++newEmonth);
        	

        	//System.out.println(event.getDescription());
        	//System.out.println(event.getType());
        	//System.out.println(event.getStart());
        	//System.out.println(event.getEnd());
        	CalendarPanel.load(event.getDescription(), event.getType(), event.getStart(), event.getEnd());
			//System.out.println(event.getStart());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	CalendarPanel.drawBorders();
	CalendarPanel.cT.repaint();
	
	
}


}
