package question1;

public class Lorry extends FourWheelTransport {

	public Lorry() {
	}

	public Lorry(String dateTime, String entertainment, double speed, int seats) {
		super(dateTime, entertainment, speed, seats);
	}
	
	public String toString() {
		return "Lorry:" + "\n" + super.toString();
	}

}
