package lexer;

public class Token {

    public Token(TokenType type){
        this.type = type;
        value = null;
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        if (value != null)
            return type + ": " + value;
        else
            return type.name();
    }

    private final TokenType type;
    private final String value;
}
