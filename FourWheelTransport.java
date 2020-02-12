package question1;

public abstract class FourWheelTransport extends Transport {
	
	private double speed;
	private int seats;

	public FourWheelTransport() {
	}

	public FourWheelTransport(String dateTime, String entertainment, double speed, int seats) {
		super(dateTime, entertainment);
		setSpeed(speed);
		setSeats(seats);
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String toString() {
		return "\tSpeed: " + getSpeed() +  "\n" + "\tSeats: " + getSeats() +  "\n" + super.toString();
	}
}
