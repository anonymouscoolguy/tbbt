package lexer;

import errors.IllegalCharacterError;

import java.util.ArrayList;

public class Lexer {

    public Lexer(String sourceCode) {
        this.sourceCode = sourceCode;
        position = -1;
        currentChar = '\0';
        advance();
    }

    public void advance() {
        position++;
        if (position < sourceCode.length()) {
            currentChar = sourceCode.charAt(position);
        } else {
            currentChar = '\0';
        }
    }

    public ArrayList<Token> generateTokens() {
        ArrayList<Token> tokens = new ArrayList<>();

        while (currentChar != '\0') {
            if (Character.isDigit(currentChar)) {
                tokens.add(generateNumberToken());
            } else {
                switch (currentChar) {
                    case ' ':
                        break;
                    case '+':
                        tokens.add(new Token(TokenType.PLUS));
                        break;
                    case '-':
                        tokens.add(new Token(TokenType.MINUS));
                        break;
                    case '*':
                        tokens.add(new Token(TokenType.MULTIPLICATION));
                        break;
                    case '/':
                        tokens.add(new Token(TokenType.DIVISION));
                        break;
                    case '(':
                        tokens.add(new Token(TokenType.LEFT_PARENTHESIS));
                        break;
                    case ')':
                        tokens.add(new Token(TokenType.RIGHT_PARENTHESIS));
                        break;
                    default:
                        System.out.println(new IllegalCharacterError("Character '" + currentChar + "' is not recognized."));
                        System.exit(1);
                }
                advance();
            }
        }

        return tokens;
    }

    public Token generateNumberToken() {
        StringBuilder stringRepresentationOfNumber = new StringBuilder();
        boolean isFloat = false;

        while ((currentChar != '\0') && (Character.isDigit(currentChar) || currentChar == '.')) {
            if (currentChar == '.') isFloat = true;
            stringRepresentationOfNumber.append(currentChar);
            advance();
        }

        if (isFloat) {
            return new Token(TokenType.FLOAT, stringRepresentationOfNumber.toString());
        } else {
            return new Token(TokenType.INT, stringRepresentationOfNumber.toString());
        }
    }

    private final String sourceCode;
    private int position;
    private char currentChar;
}
