package logic;

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
}
