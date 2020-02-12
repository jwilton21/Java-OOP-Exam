package question1;

public class Bus extends FourWheelTransport {

	public Bus() {
	}

	public Bus(String dateTime, String entertainment, double speed, int seats) {
		super(dateTime, entertainment, speed, seats);
	}
	
	public String toString() {
		return "Bus:" + "\n" + super.toString();
	}

}
