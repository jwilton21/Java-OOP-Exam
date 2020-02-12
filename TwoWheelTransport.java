package question1;

public abstract class TwoWheelTransport extends Transport {

	private double speed;
	
	public TwoWheelTransport() {
	}

	public TwoWheelTransport(String dateTime, String entertainment, double speed) {
		super(dateTime, entertainment);
		setSpeed(speed);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "\tSpeed: " + getSpeed() +  "\n" + super.toString();
	}
}
