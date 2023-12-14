package Week11;

import Week11.Exceptions.EmptyStudentListException;
import Week11.Exceptions.StudentNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentSystem {
    List<Student> students;
    public StudentSystem(String filename) {
        try {
            this.students = readStudents(filename);
        } catch (IOException e) {
            this.students = new ArrayList<>();
            System.out.println("Unable to read from the file.");
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public static List<Student> readStudents(String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<String> lines = bufferedReader.lines().toList();

        for (String line : lines) {
            String[] studentParts = line.split(",");
            Student student = new Student(
                    Integer.parseInt(studentParts[0]),
                    studentParts[1],
                    studentParts[2],
                    studentParts[3],
                    Double.parseDouble(studentParts[4])
            );
            students.add(student);
        }

        bufferedReader.close();
        return students;
    }

    public Optional<Student> getStudentByID(int id) throws StudentNotFoundException {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public Student getHighestGPAStudent() throws EmptyStudentListException{
        double highestGPA = this.students.get(0).getGPA();
        int idOfStudent = 0;
        for (Student student : students) {
            if (student.getGPA() > highestGPA) {
                highestGPA = student.getGPA();
                idOfStudent = student.getId();
            }
        }
        try {
            Optional<Student> result = getStudentByID(idOfStudent);

            if (result.isPresent()) {
                return result.get();
            } else {
                throw new EmptyStudentListException("List of students is empty.");
            }

        } catch (EmptyStudentListException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return students.get(0);
    }
}
