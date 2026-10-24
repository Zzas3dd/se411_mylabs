package edu.psu.se411.lab09_inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab09_inventory.model.Book;
import edu.psu.se411.lab09_inventory.model.ElectronicDevice;
import edu.psu.se411.lab09_inventory.model.Inventory;
import edu.psu.se411.lab09_inventory.model.Item;
import edu.psu.se411.lab09_inventory.model.SearchBookByAuthor;
import edu.psu.se411.lab09_inventory.model.SearchById;
import edu.psu.se411.lab09_inventory.model.SearchByCategory;
import edu.psu.se411.lab09_inventory.model.SearchByName;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Application is starting...");

		try {
			Inventory<Item> inventory = new Inventory<Item>();
			inventory.add(new Book("B001", "Concurrency in Java", "Salah Obeid"));
			inventory.add(new Book("B002", "Clean Code", "Robert Martin"));
			inventory.add(new ElectronicDevice("M001", "USB drive 256Gb", "Toshiba"));
			inventory.add(new ElectronicDevice("M002", "Headphones WH-1000", "Sony"));
			inventory.add(new ElectronicDevice("M003", "PlayStation 5", "Sony"));

			printResults("Search by id M001", inventory.findItems(new SearchById("M001")));
			printResults("Search by name Concurrency in Java", inventory.findItems(new SearchByName("Concurrency in Java")));
			printResults("Search by name Salah Obeid", inventory.findItems(new SearchByName("Salah Obeid")));
			printResults("Search book by author Salah Obeid", inventory.findItems(new SearchBookByAuthor("Salah Obeid")));
			printResults("Search book by author Sony", inventory.findItems(new SearchBookByAuthor("Sony")));
			printResults("Search by category Sony", inventory.findItems(new SearchByCategory("Sony")));

			printResults("Lambda search by name Clean Code",
					inventory.findItems(item -> item.getName().equalsIgnoreCase("Clean Code")));

			System.out.println("Inventory:");
			displayInventory(inventory);

		} catch (Exception e) {
			logger.error("Unexpected error: " + e.getMessage(), e);
		}

		logger.info("Application is closing...");
	}

	public static void displayInventory(Inventory<?> inventory) {
		for (Object item : inventory.getElements()) {
			System.out.println(item);
		}
	}

	private static void printResults(String title, List<Item> results) {
		System.out.println(title + ": " + results.size() + " found");
		for (Item item : results) {
			System.out.println(item);
		}
		System.out.println();
	}
}
