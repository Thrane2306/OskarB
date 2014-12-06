package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class WeatherList {
	ArrayList<Weather> weatherlist = new ArrayList<Weather>();
	
	public ArrayList<Weather> getWeatherList() {
		return weatherlist;
	}

    
    public void setWeatherList(ArrayList<Weather> weather) {
		this.weatherlist = weather;
	}
    
	public String toString() {
		return Arrays.toString(weatherlist.toArray());
	}

}