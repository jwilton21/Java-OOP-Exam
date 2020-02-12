package question1;

public class Car extends FourWheelTransport {

	public Car() {
	}

	public Car(String dateTime, String entertainment, double speed, int seats) {
		super(dateTime, entertainment, speed, seats);
	}
	
	public String toString() {
		return "Car:" + "\n" + super.toString();
	}

}
