package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Events {
	ArrayList<Event> events = new ArrayList<Event>();
	
	public ArrayList<Event> getEvents() {
		return events;
	}

    
    public void setEvents(ArrayList<Event> event) {
		this.events = event;
	}
    
	public String toString() {
		return Arrays.toString(events.toArray());
	}

}
