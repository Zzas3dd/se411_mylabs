package edu.psu.se411.lab09_inventory.model;

public class Book extends Item {

	private String authorName;

	public Book(String id, String name, String authorName) {
		super(id, name);
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return String.format("Book (id: %s, name: %s, author: %s)", getId(), getName(), getAuthorName());
	}
}
