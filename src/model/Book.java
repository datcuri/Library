package model;

import java.sql.Date;

public class Book {
	private String ID ;				// ID
	private String Name_Book;		// Tên Sách 
	private String Author;			// Tác Giả
	private String Type;			// Thể Loại
	private Date Dayexport;			// Ngày Xuất Bản
	private int Inventory;			// Số lượng
	private double Price;			// Giá

	//
	public Book() { 
		
	}
	
	public Book(String iD, String name_Book, String author, String type, Date dayexport, int inventory, double price) {
		ID = iD;
		Name_Book = name_Book;
		Author = author;
		Type = type;
		Dayexport = dayexport;
		Inventory = inventory;
		Price = price;
	}

	// get set
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public String getName_Book() {
		return Name_Book;
	}
	public void setName_Book(String name_Book) {
		Name_Book = name_Book;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDayexport() {
		return Dayexport;
	}
	public void setDayexport(Date dayexport) {
		Dayexport = dayexport;
	}
	public int getInventory() {
		return Inventory;
	}
	public void setInventory(int inventory) {
		Inventory = inventory;
	}
	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	// to string
	@Override
	public String toString() {
		return "Book [ID=" + ID + ", Name_Book=" + Name_Book + ", Author=" + Author + ", Type=" + Type + ", Dayexport="
				+ Dayexport + ", Inventory=" + Inventory + ", Price=" + Price + "]";
	}
	
}
