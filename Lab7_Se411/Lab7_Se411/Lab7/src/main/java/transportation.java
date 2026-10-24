import java.util.Date;

import exceptions.InvalidArgumentException;
import exceptions.MissingInformationException;

public abstract class transportation {
	
	protected String id;
	protected String fname;
	protected Date date;
	protected String dcity;
	
	protected transportation(String id, String fname, Date date, String dcity) {
		this.id = id;
		this.fname = fname;
		this.date = date;
		this.dcity = dcity;
	}
	
	public abstract double calculateTotalPrice();
	
	// used by all bookings to check the value entered
	protected void check(Number value, double min, double max, String name) {
		if (value == null) {
			throw new MissingInformationException(name + " is not provided");
		}
		else if (value.doubleValue() < min || value.doubleValue() > max) {
			throw new InvalidArgumentException(name + " must be between " + min + " and " + max);
		}
	}
	
	public String getId() {
		return id;
	}
	
}
