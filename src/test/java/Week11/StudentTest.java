package Week11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    void testStudentNull() {
        Student student = null;

        assertNull(student);
    }
}
