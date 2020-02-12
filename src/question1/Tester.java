package question1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class Tester {

	public static void main(String[] args) throws RuntimeException {
		Transport[] transports = new Transport[6];
		transports[0] = new Bicycle("21/12/2015 12:00", "None", 25);
		transports[1] = new eBike("18/08/2017 14:15", "None", 40);
		transports[2] = new Motorbike("21/05/2016 09:20", "None", 90);
		transports[3] = new Car("14/01/2017 13:45", "Radio, CD Player, Bluetooth", 75, 5);
		transports[4] = new Bus("07/09/2018 15:10", "Radio", 60, 30);
		transports[5] = new Lorry("01/01/2018 11:00", "Radio, CD Player", 55, 2);
		
		
		double slowestFourWheel = -1;	
		for(int i = 0; i < 6; i++) {
			if (transports[i] instanceof FourWheelTransport)
			{
				if(slowestFourWheel == -1)
					slowestFourWheel = ((FourWheelTransport)transports[i]).getSpeed();
				if(((FourWheelTransport)transports[i]).getSpeed() < slowestFourWheel)
					slowestFourWheel = ((FourWheelTransport)transports[i]).getSpeed();
			}
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(transports[i].toString());
			if(transports[i] instanceof TwoWheelTransport)
			{
				double timesSlower = slowestFourWheel / ((TwoWheelTransport)transports[i]).getSpeed();
				System.out.println("\t" + String.format("%.2f", timesSlower) + " times slower than slowest 4 wheel transport.");
			}
			else if (transports[i] instanceof FourWheelTransport)
			{
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				LocalDateTime lastServiced = LocalDateTime.parse(transports[i].getDateTime(), format);
				LocalDateTime now = LocalDateTime.now();
				
				long secondsDiff = lastServiced.until(now, ChronoUnit.SECONDS);
				int days = (int) (secondsDiff / (60*60*24));
				secondsDiff = secondsDiff - (days * 60 * 60 * 24);
				int hours = (int)(secondsDiff / (60*60));
				secondsDiff = secondsDiff - (hours * 60 * 60);
				int minutes = (int)(secondsDiff / 60);
				secondsDiff = secondsDiff - (minutes * 60);
				int seconds = (int) secondsDiff;
				
				System.out.println(String.format("\tTime since last service: %d days, %d hours, %d minutes, %d seconds", days, hours, minutes, seconds));
				
			}
			else
			{
				throw new RuntimeException("Shouldn't reach here.");
			}
		}
	}
}
