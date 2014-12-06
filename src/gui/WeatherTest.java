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
		WeatherList weatherlist = gson.fromJson(obj, WeatherList.class);
		ArrayList<Weather> weatherData = weatherlist.getWeatherList();
		//WeekCalendar.panel_3.removeAll();
		int c = 0;
		for (Weather weather : weatherData) {
			
			String date = weather.getDate();
			String celsius = weather.getCelsius();
			String desc = weather.getDesc();
		
			CalendarPanel.weatherLoad(date, desc, celsius, c);
			++c;
			
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}
	//CalendarPanel.drawBorders();
	//CalendarPanel.cT.repaint();
	
	
}


}
