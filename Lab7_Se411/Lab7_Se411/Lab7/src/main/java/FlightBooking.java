import java.util.Date;

public class FlightBooking extends transportation {
	
	protected double price;
	protected double inweight;
	protected Double lugWeight;

	public FlightBooking(String id, String fname, Date date, String dcity, double price, double inweight) {
		super(id, fname, date, dcity);
		this.price = price;
		this.inweight = inweight;
	}
	
	public FlightBooking(String id, String fname, Date date, String dcity, double price, 
			double inweight, Double lugWeight) {
		this(id, fname, date, dcity, price, inweight);
		setLugWeight(lugWeight);
	}
	
	public void setLugWeight(Double lugWeight) {
		check(lugWeight, 0, Config.MAX_LUGGAGE_WEIGHT, "Luggage weight");
		this.lugWeight = lugWeight;
	}

	@Override
	public double calculateTotalPrice() {
		check(lugWeight, 0, Config.MAX_LUGGAGE_WEIGHT, "Luggage weight");
		
		double extra = lugWeight - inweight;
		if (extra < 0) {
			extra = 0;
		}
		
		return (price + extra * Config.EXTRA_LUGGAGE_RATE) * (1 + Config.TAX_RATE);
	}

}
