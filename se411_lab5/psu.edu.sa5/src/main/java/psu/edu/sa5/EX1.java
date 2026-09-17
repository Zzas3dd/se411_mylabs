package psu.edu.sa5;

import exceptions.InvalidAgeException;

public class EX1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { validateAge(15);
		}
		catch(InvalidAgeException e) {
			System.out.println("Age should be greater than 18");
		}
	}
	
	public static void validateAge(int age) throws InvalidAgeException {
			if (age < 18) 
				throw new InvalidAgeException("18");
			
				else
				System.out.println("Age valid");
  }
	
}
