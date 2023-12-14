package Week11;

import Week11.Exceptions.StudentNotFoundException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {
        StudentSystem studentSystem = new StudentSystem("students.csv");

        for (Student student : studentSystem.getStudents()) {
            // System.out.println(student);
        }

        try {
            Optional<Student> foundStudent = studentSystem.getStudentByID(99);

            if (foundStudent.isPresent()) {
                Student student = foundStudent.get();
                System.out.println("Found student: " + student.getName() + " with ID: " + student.getId());
            } else {
                throw new StudentNotFoundException("Student with that particular ID is not found");
            }

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(studentSystem.getHighestGPAStudent());
    }
}
