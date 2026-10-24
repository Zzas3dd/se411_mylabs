import java.util.Date;

public class TrainBooking extends transportation {

	private SeatClass c;
	private Double distance;
	
	public TrainBooking(String id, String fname, Date date, String dcity, SeatClass c) {
		super(id, fname, date, dcity);
		this.c = c;
	}
	
	public TrainBooking(String id, String fname, Date date, String dcity, SeatClass c, Double distance) {
		this(id, fname, date, dcity, c);
		setDistance(distance);
	}
	
	public void setDistance(Double distance) {
		check(distance, Config.MIN_TRAIN_DISTANCE, Config.MAX_TRAIN_DISTANCE, "Distance");
		this.distance = distance;
	}

	@Override
	public double calculateTotalPrice() {
		check(distance, Config.MIN_TRAIN_DISTANCE, Config.MAX_TRAIN_DISTANCE, "Distance");
		
		if (c == SeatClass.FIRST_CLASS) {
			return distance * Config.TRAIN_FIRST_CLASS_RATE;
		}
		else return distance * Config.TRAIN_STANDARD_RATE;
	}
	
}
