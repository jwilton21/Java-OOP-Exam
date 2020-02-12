package question1;

public abstract class Transport {
	private String dateTime;
	private String entertainment;
	
	public Transport(){
	}
	
	public Transport(String dateTime, String entertainment){
		setDateTime(dateTime);
		setEntertainment(entertainment);
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getEntertainment() {
		return entertainment;
	}
	
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}
	
	public String toString() {
		return "\tService Date: " + getDateTime() +  "\n" + "\tEntertainment: " + getEntertainment();
	}
}
