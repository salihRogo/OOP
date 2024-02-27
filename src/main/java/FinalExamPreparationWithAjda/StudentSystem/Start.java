package FinalExamPreparationWithAjda.StudentSystem;

import java.io.IOException;

public class Start {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        try {
            StudentSystem.generateReportAboutStudents("files/report.csv");
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
