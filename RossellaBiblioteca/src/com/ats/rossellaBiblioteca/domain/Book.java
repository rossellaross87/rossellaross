package com.ats.rossellaBiblioteca.domain;

public class Book {

	private int id;
	private String isbn;
	private String title;
	private String description;
	private double price;
	private int numPages;
	private String category;
	//Questo costruttore mi serve per leggere i libri (serve l' id)
	public Book(int id, String isbn, String title, String description,
			double price, int numPages, String category, String publisher) {
		
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.price = price;
		this.numPages = numPages;
		this.category = category;
		this.publisher = publisher;
	}
	//Questo costruttore mi serve per inserire i libri (non serve l' id)
	public Book(String isbn, String title, String description, double price,
			int numPages, String category, String publisher) {
	
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.price = price;
		this.numPages = numPages;
		this.category = category;
		this.publisher = publisher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumPages() {
		return numPages;
	}
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	private String publisher;
}
