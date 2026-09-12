package se411.lab3;

public class NumberBox<T extends Number> {
	private T num;
	
	public void setItem(T num) {
		this.num = num;
	}
	
	public T getItem() {
		return num;
	}
	
	public double sum(T other) {
		return num.doubleValue() + other.doubleValue();
	}
}
