package Week11;

import Week11.Exceptions.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTest {

    @Test
    void testifStudentisPresent() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        assertTrue(studentSystem.getStudents().size() != 0);
    }

    @Test
    void testStudentWithId100() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        try {
            assertFalse(studentSystem.getStudentByID(100).isPresent());
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    void testSize() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        assertEquals(70, studentSystem.getStudents().size());
    }

    @Test
    void testLargestName() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        assertNotEquals("Ava White", studentSystem.getLongestNameStudent());
    }

    @Test
    void testStudents() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        assertNotEquals(studentSystem.getHighestGPAStudent(), studentSystem.getLongestNameStudent());
    }

    @Test
    void testSameStudent() {
        StudentSystem studentSystem = new StudentSystem("files/students.csv");

        assertEquals(12, studentSystem.getHighestGPAStudent().getId());
    }
}