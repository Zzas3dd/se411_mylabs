import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.InvalidArgumentException;
import exceptions.MissingInformationException;

public class MainApp {
	
	static Logger logger = LoggerFactory.getLogger(MainApp.class);
	
	public static double computeTotalPrice(transportation booking) {
		return booking.calculateTotalPrice();
	}

	public static void main(String[] args) {
		logger.info("Application is starting...");
		
		transportation fbooking = new FlightBooking("B001", "John Doe", new java.util.Date(), "New York", 200.0, 30.0, 20.0);
		fbooking.calculateTotalPrice();
		System.out.println("Total Price: " + fbooking.calculateTotalPrice());
		
		transportation cbooking = new CarRentalBooking("B002", "Jane Smith", new java.util.Date(), "Los Angeles", 50.0, 10);
		cbooking.calculateTotalPrice();
		System.out.println("Total Price: " + cbooking.calculateTotalPrice());
		
		SeatClass seatClass = SeatClass.STANDARD_CLASS;
		transportation tbooking = new TrainBooking("B003", "Alice Johnson", new java.util.Date(), "Chicago", seatClass, 100.0);
		System.out.println("Total Price: " + tbooking.calculateTotalPrice());
		
		// polymorphism
		transportation[] bookings = {fbooking, cbooking, tbooking};
		for (transportation b : bookings) {
			System.out.println(b.getId() + " total: " + computeTotalPrice(b));
		}
		
		// exceptions
		try {
			transportation f = new FlightBooking("B004", "Ali", new Date(), "Paris", 250.0, 20.0);
			computeTotalPrice(f);
		} catch (MissingInformationException e) {
			System.out.println(e.getMessage());
			logger.error("MissingInformationException: " + e.getMessage());
		}
		
		try {
			new FlightBooking("B005", "Sara", new Date(), "London", 250.0, 20.0, 50.0);
		} catch (InvalidArgumentException e) {
			System.out.println(e.getMessage());
			logger.error("InvalidArgumentException: " + e.getMessage());
		}
		
		try {
			new TrainBooking("B006", "Omar", new Date(), "Dammam", SeatClass.FIRST_CLASS, 2500.0);
		} catch (InvalidArgumentException e) {
			System.out.println(e.getMessage());
			logger.error("InvalidArgumentException: " + e.getMessage());
		}
		
		try {
			new CarRentalBooking("B007", "Noura", new Date(), "Jeddah", 60.0, 45);
		} catch (InvalidArgumentException e) {
			System.out.println(e.getMessage());
			logger.error("InvalidArgumentException: " + e.getMessage());
		}
		
		logger.info("Application is stopping...");
	}

}
