import java.util.Date;

public class CarRentalBooking extends transportation {
	
	protected double rate;
	protected Integer days;
	
	public CarRentalBooking(String id, String fname, Date date, String dcity, double rate) {
		super(id, fname, date, dcity);
		this.rate = rate;
	}
	
	public CarRentalBooking(String id, String fname, Date date, String dcity, double rate, Integer days) {
		this(id, fname, date, dcity, rate);
		setDays(days);
	}
	
	public void setDays(Integer days) {
		check(days, Config.MIN_RENTAL_DAYS, Config.MAX_RENTAL_DAYS, "Rental days");
		this.days = days;
	}

	@Override
	public double calculateTotalPrice() {
		check(days, Config.MIN_RENTAL_DAYS, Config.MAX_RENTAL_DAYS, "Rental days");
		return rate * days;
	}

}
