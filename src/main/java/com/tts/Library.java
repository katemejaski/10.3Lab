package com.tts;

public class Library {
    public String libraryAddress;
    public Book[] Books = new Book[0];

    public Library(String address) {
        libraryAddress = address;
    }

    public void addBook(Book item) {
        int Len = Books.length;
        Book[] Temp = new Book[Len + 1];
        for (int I = 0; I < Len; I++)
            Temp[I] = Books[I];

        Temp[Len] = item;
        Books = new Book[Temp.length];
        for (int I = 0; I < Books.length; I++)
            Books[I] = Temp[I];
    }



    public void returnBook(String returningBook) {
        for (int I = 0; I < Books.length; I++)
            if (Books[I].getTitle().compareTo(returningBook) == 0)
                if (Books[I].isBorrowed())
                {
                    Books[I].returned();
                    System.out.println("You successfully returned " + returningBook);
                    return;
                }
        System.out.println("Sorry, this book is not from our catalog.");
    }


    public void printAvailableBooks() {
        for (int I = 0; I < Books.length; I++)
            if (!Books[I].isBorrowed())
                System.out.println(Books[I].getTitle());

        if (Books.length == 0)
            System.out.println("Sorry, this book is not in our catalog.");
    }


    public void borrowBook(String requestedBook) {
        for (int I = 0; I < Books.length; I++)
            if (Books[I].getTitle().compareTo(requestedBook) == 0)
                if (Books[I].isBorrowed())
                {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                } else
                {
                    Books[I].rented();
                    System.out.println("You successfully borrowed " + requestedBook);
                    return;
                }
        System.out.println("Sorry, this book is not in our catalog.");
    }


    public static void printOpeningHours() {
        System.out.println("Library is open daily from 9am to 5pm.");
    }


    public void printAddress() {
        System.out.println(this.libraryAddress);
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        // Print opening hours and the addresses
        System.out.println("Library Hours:");
        printOpeningHours();
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