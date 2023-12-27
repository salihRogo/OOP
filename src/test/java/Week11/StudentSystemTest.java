package Week11;

import Week11.Exceptions.EmptyStudentListException;
import Week11.Exceptions.StudentNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


class StudentSystemTest {
    static StudentSystem system;

    @BeforeEach
    void init() {
        try {
            system = new StudentSystem("files/students.csv");
            if (system.getStudents().isEmpty()) {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("Failed to initialize StudentSystem: " + e.getMessage());
        }
    }

    @Test
    void testifStudentisPresent() {
        assertTrue(system.students.size() > 0);
    }

    @Test
    void teststudentWithId100() {
        assertFalse(system.getStudentByID(100).isPresent());
    }


    @Test
    void testStudentWithId100() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Optional<Student> studentWithId100;

        studentWithId100 =  studentSystem.getStudentByID(100);


        assertFalse(studentWithId100.isPresent());
    }

    @Test
    void testStudentNull() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Optional<Student> studentOptional;

        try {
            studentOptional = studentSystem.getStudentByID(1);
            Student student = studentOptional.orElse(null);

            if (Objects.equals(student, null)) {
                throw new StudentNotFoundException();
            }

        } catch (StudentNotFoundException e) {
            throw new RuntimeException();
        }

        assertNotNull(studentOptional.isPresent());
    }

    @Test
    public void testHighestGPAStudent() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Optional<Student> highestGPAStudentOptional;
        try {
            highestGPAStudentOptional = Optional.ofNullable(studentSystem.getHighestGPAStudent());
            if (highestGPAStudentOptional.isEmpty()) {
                throw new EmptyStudentListException();
            }
        } catch (EmptyStudentListException e) {
            throw new RuntimeException();
        }

        assertTrue(highestGPAStudentOptional.isPresent());
    }

    @Test
    public void testExceptionForEmptyStudentList() {
        StudentSystem studentSystem = new StudentSystem("files/empty.csv");

        assertThrows(EmptyStudentListException.class, studentSystem::getHighestGPAStudent);
    }

    @Test
    public void testNamesArray() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        List<String> actualNames = studentSystem.getStudents().stream()
                .limit(5) // Take the first five elements
                .map(Student::getName)
                .toList();

        List<String> expectedNames = List.of("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson");

        assertEquals(expectedNames, actualNames);
    }

    @Test
    void testSize() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        int expectedSize = 70;

        assertEquals(expectedSize, studentSystem.getStudents().size());
    }

    @Test
    public void testLargestName() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Student largestNameStudent;
        try {
            largestNameStudent = studentSystem.getLongestNameStudent();
        } catch (EmptyStudentListException e) {
            largestNameStudent = null;
        }

        String expectedName = "Ava White";

        assertNotEquals(expectedName, largestNameStudent != null ? largestNameStudent.getName() : null);
    }

    @Test
    public void testStudents() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Student highestGPAStudent;
        try {
            highestGPAStudent = studentSystem.getHighestGPAStudent();
        } catch (EmptyStudentListException e) {
            highestGPAStudent = null;
        }

        Student longestNameStudent;
        try {
            longestNameStudent = studentSystem.getLongestNameStudent();
        } catch (EmptyStudentListException e) {
            longestNameStudent = null;
        }

        assertNotSame(highestGPAStudent, longestNameStudent);
    }

    @Test
    public void testSameStudent() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        Student highestGPAStudent;
        try {
            highestGPAStudent = studentSystem.getHighestGPAStudent();
        } catch (EmptyStudentListException e) {
            highestGPAStudent = null;
        }

        Optional<Student> studentWithId12;
        try {
            studentWithId12 =  studentSystem.getStudentByID(100);

            if (studentWithId12.isPresent()) {
                throw new StudentNotFoundException();
            }

        } catch (StudentNotFoundException e) {
            throw new RuntimeException();
        }

        assertNotSame(studentWithId12.orElse(null), highestGPAStudent);
    }
}