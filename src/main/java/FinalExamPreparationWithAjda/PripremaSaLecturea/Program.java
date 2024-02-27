package FinalExamPreparationWithAjda.PripremaSaLecturea;

public class Program {
    public static void main(String[] args) {
        ReadFromFile read = new ReadFromFile("files/books.csv");

        GenerateCustomReport.writeReport("files/books-report.csv", read.getItems());
    }
}
