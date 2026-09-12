package se411.lab3;
import java.util.*;

public class PrintableList<T> {
	private List<T> elements;
	
	public PrintableList(T[] someArray) {
		elements = Arrays.asList(someArray);
	}
	
	public List<T> getList() {
		return elements;
	}
	
	public void printList() {
		for (T e : elements) {
			System.out.println(e);
		}
	}
	
	
}
