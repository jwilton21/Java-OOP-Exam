package question1;

public class Bicycle extends TwoWheelTransport {

	public Bicycle() {
	}

	public Bicycle(String dateTime, String entertainment, double speed) {
		super(dateTime, entertainment, speed);
	}
	
	public String toString() {
		return "Bicycle:" + "\n" + super.toString();
	}

}
