package Week6.Lab.LibraryManagemntSystem;

import java.util.ArrayList;

class StringUtils {
    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
        String copyOfWord = word;

        copyOfWord = copyOfWord.trim();
        searched = searched.trim();

        copyOfWord = copyOfWord.toUpperCase();
        searched = searched.toUpperCase();

        return copyOfWord.contains(searched);
    }
}

class Book {
    private String title;
    private String publisher;
    private int year;

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String title() {
        return title;
    }

    public String publisher() {
        return publisher;
    }

    public int year() {
        return year;
    }

    @Override

    public String toString() {
        return this.title + ", " + this.publisher + ", " + this.year;
    }
}

class Library extends StringUtils {
    ArrayList<Book> library = new ArrayList<>();

    public Library() {

    }

    public void addBook(Book newBook) {
        this.library.add(newBook);
    }

    public void printBooks() {
        for (Book b : this.library) {
            System.out.println(b);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<>();

        for (Book b : this.library) {
            if (Library.included(b.title(), title)) {
                found.add(b);
            }
        }

        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<>();

        for (Book b : this.library) {
            if (Library.included(b.publisher(), publisher)) {
                found.add(b);
            }
        }

        return found;
    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<>();

        for (Book b : this.library) {
            if (b.year() == year) {
                found.add(b);
            }
        }

        return found;
    }
}

class Main {
    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        for (Book book: Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }
    }
}
