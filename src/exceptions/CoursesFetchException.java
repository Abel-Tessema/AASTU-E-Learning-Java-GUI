package exceptions;

public class CoursesFetchException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to fetch courses. Please refresh.";
    }
}
