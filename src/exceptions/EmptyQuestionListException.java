package exceptions;

public class EmptyQuestionListException extends RuntimeException {
    public EmptyQuestionListException(String message) {
        super(message);
    }
}
