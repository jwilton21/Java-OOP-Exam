package question1;

public class Motorbike extends TwoWheelTransport {

	public Motorbike() {
	}

	public Motorbike(String dateTime, String entertainment, double speed) {
		super(dateTime, entertainment, speed);
	}

	public String toString() {
		return "Motorbike:" + "\n" + super.toString();
	}
}
