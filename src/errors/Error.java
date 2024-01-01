package errors;

public class Error {

    public Error(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String toString() {
        return name + ": " + details;
    }

    private final String name;
    private final String details;
}
