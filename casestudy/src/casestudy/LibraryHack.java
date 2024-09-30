package casestudy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Book{
    int bookIsbnNo;
	String author;
    String publisher;
    float price; 
    
    public Book(int bookIsbnNo, String author, String publisher, float price) {
        this.bookIsbnNo = bookIsbnNo;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    
    public int getBookIsbnNo() {
		return bookIsbnNo;
	}
	public void setBookIsbnNo(int bookIsbnNo) {
		this.bookIsbnNo = bookIsbnNo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return "Book [ISBN=" + bookIsbnNo + ", Author=" + author + ", Publisher=" + publisher + ", Price=" + price + "]";
    }
}

class LibraryService{
    String libraryName;
    String address;
    List<Book>   books;
    
    public LibraryService(String libraryName, String address){
    	
    	this.libraryName = libraryName;
    	this.address = address;
    	this.books = new ArrayList<>();
    	
    }
    
	public List<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void removeBook(int bookIsbnNo) {
		books.remove(bookIsbnNo);
	}
	
	public Book findMaxPrice(String publisher) {
		Optional<Book> maxPrice = books.stream()
										.filter(b->b.getPublisher().equals(publisher))
										.max(Comparator.comparing(Book::getPrice));
	
		return maxPrice.orElse(null);
	}
    
}

class Customer{
    String customerName;
    String address;
    List<Book> borrowed;
    
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Book> getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(List<Book> borrowed) {
		this.borrowed = borrowed;
	}
    
}

public class LibraryHack {

	public static void main(String[] args) {
		
		LibraryService libraryService = new LibraryService("Just Reading Library", "Tier 2 Town");
        libraryService.addBook(new Book(111, "A", "ABC", 250.50f));
        libraryService.addBook(new Book(112, "B", "DEF", 300.00f));
        libraryService.addBook(new Book(113, "C", "HIJ", 150.75f));
        libraryService.addBook(new Book(114, "D", "ABC", 450.00f));
        libraryService.addBook(new Book(115, "E", "DEF", 220.30f));
		
		System.out.print("Enter User Type(admin/customer): ");
		
		Scanner input = new Scanner(System.in);
		String Usertype = input.nextLine();
		
		if(Usertype.equals("admin")) {
			System.out.print("1. View all books\n2. Add new book\n3. Delete book\n4. Get a publishers most costly book\nOption: ");
			int adminOption = input.nextInt();
			input.nextLine();
			
			switch(adminOption) {
				case 1:
					List<Book> b = libraryService.getBooks();
					b.forEach(System.out::print);
					break;
				case 2:
					System.out.println("Enter ISBN No, Author, Publisher, and Price of the new book:");
                    int isbn = input.nextInt();
                    input.nextLine();
                    
                    String author = input.nextLine();
                    String publisher = input.nextLine();
                    float price = input.nextFloat();
                    input.nextLine(); 
                    
                    libraryService.addBook(new Book(isbn, author, publisher, price));
                    break;
					
				case 3:
					System.out.println("Enter ISBN of the book to remove:");
                    int isbnRem = input.nextInt();
                     
                    input.nextLine();
                     
                    libraryService.removeBook(isbnRem);
					break;
				case 4:
					System.out.println("Enter the publisher's name:");
					
                    String publisherName = input.nextLine();
                    Book costlyBook = libraryService.findMaxPrice(publisherName);
                    
                    if (costlyBook != null) {
                        System.out.println("Costliest Book: " + costlyBook.toString());
                    } else {
                        System.out.println("No books found for publisher: " + publisherName);
                    }
					break;
			}
		}
		else if(Usertype.equals("customer")) {
			System.out.print("1. View all books\n2. Get a publishers most costly book\nOption: ");
			int customerOption = input.nextInt();
			input.nextLine();
			
			switch(customerOption) {
			case 1:
				List<Book> b = libraryService.getBooks();
                b.forEach(System.out::println);
				break;
			case 2:
				System.out.println("Enter the publisher's name:");
                String publisherName = input.nextLine();
                
                Book costlyBook = libraryService.findMaxPrice(publisherName);
                
                if (costlyBook != null) {
                    System.out.println("Costliest Book: " + costlyBook.toString());
                } else {
                    System.out.println("No books found for publisher " + publisherName);
                }
				break;
			default:
				System.out.println("Invalid");
			}
		}
		
		input.close();
	}

}
