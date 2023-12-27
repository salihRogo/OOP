package Week11.Exceptions;

import java.util.NoSuchElementException;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException() {
    }
}
