import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("tbbt > ");
            String in = scanner.nextLine();
            if (in.equals("exit")) {
                System.exit(0);
            }

            Lexer lexer = new Lexer(in);
            ArrayList<Token> tokens = lexer.generateTokens();
            System.out.println(tokens.toString());

            System.out.println(in);
        }
    }
}
