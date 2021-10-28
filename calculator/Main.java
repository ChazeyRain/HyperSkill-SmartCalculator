package calculator;

import calculator.commands.CommandHandler;
import calculator.commands.Commands;
import calculator.expressions.ExpressionHandler;
import calculator.menu.CLI;
import calculator.variables.AssignmentStatus;
import calculator.variables.Variables;

import java.util.Objects;

public class Main {
    //I don't know why, but I've added support for parentheses, multiplication and division)

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            isRunning = input();
        }
    }

    public static boolean input() {
        String input = CLI.getInput();

        if (input.matches("")) {
            return true;
        }

        if (input.matches("/.*")) {
            Commands cmd = CommandHandler.handle(input);
            CLI.print(cmd);
            return cmd.shouldRun();
        }

        if (input.contains("=")) {
            AssignmentStatus status = Variables.assign(input);
            if (status != AssignmentStatus.OK) {
                CLI.print(status);
            }
            return true;
        }

        String expression = Variables.insertNumbers(input);

        if (expression == null) {
            CLI.print(AssignmentStatus.UNKNOWN_VARIABLE);
            return true;
        }

        String result = ExpressionHandler.handle(expression);

        CLI.print(Objects.requireNonNullElse(result, "Invalid expression"));

        return true;
    }
}
