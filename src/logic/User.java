package logic;

public class User {
	private String username;
	private String password;
	private String UserId;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setCBSUser(String UserId) {
		this.UserId = UserId;
	}
	public String getUserId() {
		return UserId;
	}
}