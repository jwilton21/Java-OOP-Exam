package question1;

public class eBike extends TwoWheelTransport {

	public eBike() {
	}

	public eBike(String dateTime, String entertainment, double speed) {
		super(dateTime, entertainment, speed);
	}
	
	public String toString() {
		return "eBike:" + "\n" + super.toString();
	}

}
