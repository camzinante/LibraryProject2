package libraryProject2;

import java.util.ArrayList;

public class Library {

    private String address;
    private ArrayList<libraryProject2.Book> catalog = new ArrayList();

    public Library(String libraryAddress) {
        this.address = libraryAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<libraryProject2.Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<libraryProject2.Book> catalog) {
        this.catalog = catalog;
    }

    public void addBook(libraryProject2.Book bookToAdd) {
        getCatalog().add(bookToAdd);
    }
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9 to 5");
    }
    public void printAddress() {
        System.out.println(this.getAddress());
    }
    public void borrowBook(String titleOfBookToBorrow) {
        libraryProject2.Book bookToFind = null;
        for (libraryProject2.Book bookInCatalog : this.getCatalog()) {
            if(bookInCatalog.getTitle().equalsIgnoreCase(titleOfBookToBorrow)){
                bookToFind = bookInCatalog;
            }
        }
        if(bookToFind == null) {
            System.out.println("Book not in catalog");
        } else {
            if(bookToFind.isBorrowed()) {
                System.out.println("Book is borrowed");
            } else {
                bookToFind.borrowed();
                System.out.printf("You successfully borrowed %s\n", bookToFind.getTitle());
            }
        }
    }
    public void printAvailableBooks() {
        if(this.getCatalog().size() == 0) {
            System.out.println("No books this in catalog ");
        } else {
            for(libraryProject2.Book bookInCatalog : this.getCatalog()) {
                System.out.println(bookInCatalog.getTitle());
            }
        }
    }
    public void returnBook(String titleOfBookToReturn) {
        libraryProject2.Book bookToReturn = null;
        for (libraryProject2.Book bookInCatalog : this.getCatalog()) {
            if(bookInCatalog.getTitle().equalsIgnoreCase(titleOfBookToReturn)){
                bookToReturn = bookInCatalog;
            }
        }
        if(bookToReturn == null){
            System.out.println("Book not in catalog.");
        } else {
            if (!(bookToReturn.isBorrowed())) {
                System.out.println("This book was returned");
            } else {
                bookToReturn.returned();
                System.out.printf("You successfully returned %s\n", bookToReturn.getTitle());
            }
        }
    }

    public static void main(String[] args) {

        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        firstLibrary.addBook(new libraryProject2.Book("The da Vinci Code"));
        firstLibrary.addBook(new libraryProject2.Book("Le petit Prince"));
        firstLibrary.addBook(new libraryProject2.Book("A Tale of Two Cities"));
        firstLibrary.addBook(new libraryProject2.Book("The Lord of The Rings"));

        System.out.println("Borrowing The Lord of The Rings:");
        firstLibrary.borrowBook("The Lord of The Rings");
        firstLibrary.borrowBook("The Lord of The Rings");
        secondLibrary.borrowBook("The Lord of The Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();

        System.out.println("Returning The Lord of The Rings:");
        firstLibrary.returnBook("The Lord of The Rings");

        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
