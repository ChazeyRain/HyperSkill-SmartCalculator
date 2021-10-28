package calculator.menu;

import java.util.Scanner;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        String input = scanner.nextLine().trim();
        return input;
    }

    public static void print(Object text) {
        System.out.println(text);
    }

}
