package gui;

import java.util.ArrayList;

import logic.Event;
import logic.Events;
import logic.Switch;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CBSTEST {

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

				CalendarPanel.load(event.getDescription(), event.getType(),
						event.getStart(), event.getEnd(), event.getLocation(),
						event.getEventid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CalendarPanel.drawBorders();
		CalendarPanel.cT.repaint();

	}

}
