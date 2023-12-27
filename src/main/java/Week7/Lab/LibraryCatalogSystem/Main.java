package Week7.Lab.LibraryCatalogSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

record Book(String title, String author, int publicationYear, boolean availabiltyStatus) {}

class LibraryCatalog {
    public List<Book> books;

    public LibraryCatalog(List<Book> catalog) {
        this.books = catalog;
    }

    public Optional<Book> checkAvailability(String searchedBook){
        return books.stream()
                .filter(book -> book.title().equals(searchedBook) && book.availabiltyStatus())
                .findFirst();
    }

    public Optional<Book> getFirstAvailableBookByAuthor(String authors_name) {
        return books.stream()
                .filter(book -> book.author().equals(authors_name) && book.availabiltyStatus())
                .findFirst();
    }

    public void updateAvailability(String title, boolean status) {
        books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .ifPresent(book -> books.set(books.indexOf(book), new Book(book.title(), book.author(), book.publicationYear(), status)));
    }
}

class Start {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, false),
                new Book("1984", "George Orwell", 1949, true)
        );

        LibraryCatalog libraryCatalog = new LibraryCatalog(bookList);

        Optional<Book> availableBook = libraryCatalog.checkAvailability("1984");
        System.out.println("Is '1984' availabiltyStatus? " + availableBook.isPresent());

        Optional<Book> firstAvailableByAuthor = libraryCatalog.getFirstAvailableBookByAuthor("J.D. Salinger");
        System.out.println("First availabiltyStatus book by J.D. Salinger: " + firstAvailableByAuthor.orElse(null));

        libraryCatalog.updateAvailability("To Kill a Mockingbird", true);
        System.out.println("Updated availability of 'To Kill a Mockingbird'");

        System.out.println("Updated Book List:");
        libraryCatalog.books.forEach(book -> System.out.println(book.title() + " - Available: " + book.availabiltyStatus()));
    }
}


