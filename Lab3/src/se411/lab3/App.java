package se411.lab3;

import java.util.*;

public class App {
	public static void main(String[] args) {
		
		String[] stringArray = {"Hello", "Hi", "Ciao"};
		PrintableList<String> stringList = new PrintableList<String>(stringArray);
		stringList.printList();
		
		Integer[] intArray = {1 , 2 , 3};
		PrintableList<Integer> intList = new PrintableList<Integer>(intArray);
		intList.printList();
		
		NumberBox<Number> num1 = new NumberBox<>();
		num1.setItem(12);
		System.out.println(num1.getItem());
		System.out.println(num1.sum(59));
		
		NumberBox<Number> num2 = new NumberBox<>();
		num2.setItem(12.5);
		System.out.println(num1.getItem());
		System.out.println(num2.sum(6));
		
		
		printList(stringList.getList());
        System.out.println(sumNumbers(intList.getList()));
    
		
	}
	
	public static void printList(List<?> list) {
			for (Object o : list) {
				System.out.println(o);
			}
		}
	
	public static double sumNumbers(List<? extends Number> numlist) {
		double sum = 0;
		
		for (Number n : numlist) {
			sum += n.doubleValue();
		}
		
		return sum;
	}
}

