package edu.psu.se411.lab09_inventory.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {

	private List<T> elements;

	public Inventory() {
		this.elements = new ArrayList<T>();
	}

	public Inventory(List<T> elements) {
		this.elements = elements;
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public void add(T element) {
		getElements().add(element);
	}

	public boolean remove(T element) {
		return getElements().remove(element);
	}

	public List<T> findItems(SearchCriteria<T> strategy) {
		List<T> results = new ArrayList<T>();
		for (T element : getElements()) {
			if (strategy.matches(element)) {
				results.add(element);
			}
		}
		return results;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(String.format("Inventory (%d items):%n", getElements().size()));
		for (T element : getElements()) {
			result.append(String.format("  %s%n", element));
		}
		return result.toString();
	}
}
