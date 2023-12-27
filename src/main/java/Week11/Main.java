package Week11;

import Week11.Exceptions.EmptyStudentListException;
import Week11.Exceptions.StudentNotFoundException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        try {
            Optional<Student> result = studentSystem.getStudentByID(10);
            if (result.isPresent()) {
                System.out.println(result.get());
            } else {
                throw new StudentNotFoundException("Student with that particular ID doesn't exist.");
            }
        } catch (StudentNotFoundException snfe) {
            System.out.println(snfe.getMessage());
        }

        try {
            System.out.println(studentSystem.getHighestGPAStudent());
        } catch (EmptyStudentListException esle) {
            System.out.println(esle.getMessage());
        }

        try {
            System.out.println(studentSystem.getLongestNameStudent());
        } catch (EmptyStudentListException esle) {
            System.out.println(esle.getMessage());
        }
    }
}
