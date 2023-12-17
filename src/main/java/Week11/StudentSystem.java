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
        ArrayList<Student> students = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<String> lines = bufferedReader.lines().toList();

        for (String line : lines) {
            String[] studentParts = line.split(",");
            Student tempStudent = new Student(
                    !studentParts[0].equals("") ? Integer.parseInt(studentParts[0]) : 000,
                    studentParts[1],
                    studentParts[2],
                    studentParts[3],
                    !studentParts[4].equals("") ? Double.parseDouble(studentParts[4]) : 000
            );
            students.add(tempStudent);
        }
        bufferedReader.close();
        return students;
    }

    public Optional<Student> getStudentByID(int searchedId) throws StudentNotFoundException {
        return students.stream()
                .filter(student -> student.getId() == searchedId)
                .findFirst();
    }

    public Student getHighestGPAStudent() throws EmptyStudentListException {
        if (this.students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        } else {
            double highestGPA = 0;
            int indexOfHighestGPA = 0;
            for (int i = 0; i < this.students.size(); i++) {
                if (this.students.get(i).getGpa() > highestGPA) {
                    highestGPA = this.students.get(i).getGpa();
                    indexOfHighestGPA = i;
                }
            }
            return this.students.get(indexOfHighestGPA);
        }
    }

    public Student getLongestNameStudent() throws EmptyStudentListException {
        if (this.students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        } else {
            int lengthOfLongest = 0;
            int indexOfLongest = 0;
            for (int i = 0; i < this.students.size(); i++) {
                if (this.students.get(i).getName().length() > lengthOfLongest) {
                    lengthOfLongest = this.students.get(i).getName().length();
                    indexOfLongest = i;
                }
            }
            return this.students.get(indexOfLongest);
        }
    }
}
