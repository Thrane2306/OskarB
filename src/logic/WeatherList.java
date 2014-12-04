package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class WeatherList {
	ArrayList<Weather> weatherList = new ArrayList<Weather>();
	
	public ArrayList<Weather> getWeather() {
		return weatherList;
	}

    
    public void setweatherList(ArrayList<Weather> weather) {
		this.weatherList = weather;
	}
    
	public String toString() {
		return Arrays.toString(weatherList.toArray());
	}

}
