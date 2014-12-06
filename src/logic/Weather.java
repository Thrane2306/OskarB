package logic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes.
 */
public class Weather {
    private String celsius;
    private String desc;
    private String quote;
    private String date;
    
    ArrayList<Weather> weatherlist = new ArrayList<Weather>();
    
    public void setWeatherList(ArrayList<Weather> weather) {
		this.weatherlist = weather;
	}
    
	public String toString() {
		return Arrays.toString(weatherlist.toArray());
	}

    // Settere og gettere for Event objektet 
    public void setCelsius(String celsius){
        this.celsius = celsius;
    }
    public String getCelsius(){
        return celsius;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return desc;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }
    public String getQuote(){
        return quote;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
	public Weather(String celsius, String desc, String quote, String date) {
		super();
		this.celsius = celsius;
		this.desc = desc;
		this.quote = quote;
		this.date = date;
	}
}