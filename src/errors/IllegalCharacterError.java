package errors;

public class IllegalCharacterError extends Error {

    public IllegalCharacterError(String details) {
        super("Illegal Character errors.Error", details);
    }
}
