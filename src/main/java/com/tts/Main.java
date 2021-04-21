package com.tts;

public class Main {
    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());

        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
    // Print opening hours and the addresses
        System.out.println("Library Hours:");
        System.out.println("The Library is open from 9am to 5pm");
        System.out.println();
        System.out.println("Library Locations:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
    // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
    // Print the titles of all available books from both libraries
        System.out.println("Book is available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Book is available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
    // Return The Lords of the Rings to the first
    // library
        System.out.println("Returning Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
    // Print the titles of available from the first library
        System.out.println("Book is available in the first library:");
        firstLibrary.printAvailableBooks();
}
}
