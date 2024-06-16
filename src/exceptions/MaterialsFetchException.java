package exceptions;

public class MaterialsFetchException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to fetch materials. Please try again.";
    }
}
