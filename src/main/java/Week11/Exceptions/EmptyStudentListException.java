package Week11.Exceptions;

public class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }

    public EmptyStudentListException() {
    }
}
