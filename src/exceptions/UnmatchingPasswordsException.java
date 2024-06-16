package exceptions;

public class UnmatchingPasswordsException extends Exception {
    @Override
    public String getMessage() {
        return "The new and confirmed passwords do not match. Please try again.";
    }
}
