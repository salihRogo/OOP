package PreparationWithIdiots;

public class Start {
    public static void main(String[] args) {
        BookStoreSystem bookStoreSystem = new BookStoreSystem("files/books.csv");

        GenerateReport.writeReport("files/books-report.csv", bookStoreSystem.getItems());
    }
}
