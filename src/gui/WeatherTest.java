package gui;

import java.util.ArrayList;

import logic.Event;
import logic.Events;
import logic.Switch;
import logic.Weather;
import logic.WeatherList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherTest {
	
	private static String info, info2;
	private static ArrayList<String> info3, info4;
	
	
	public WeatherTest() {
	String overallID;
	overallID = "getWeather";
	
	
	try {
		String answer = Switch.switchMethod(overallID, "", "");
		JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(answer).getAsJsonObject();
        Gson gson = new Gson();
        WeatherList weatherList = gson.fromJson(obj, WeatherList.class);
       // CalendarPanel.cT.removeAll();
		
        ArrayList<Weather> weatherData = weatherList.getWeather();
        
        for (Weather weather : weatherData) {
        	
        	String date =  weather.getDate();
        	String desc =  weather.getDesc();
        	String celsius =  weather.getCelsius();
        	String qotd =  weather.getQuote();
        	
        	
        	 
        	
        	

        	System.out.println(date);
        	System.out.println(desc);
        	System.out.println(celsius);
        	System.out.println(qotd);
        	//CalendarPanel.load(event.getDescription(), event.getType(), event.getStart(), event.getEnd());
			//System.out.println(event.getStart());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//CalendarPanel.drawBorders();
	//CalendarPanel.cT.repaint();
	
	
}


}
