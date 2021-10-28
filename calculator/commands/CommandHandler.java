package calculator.commands;

import calculator.menu.CLI;

public class CommandHandler {

    public static Commands handle(String command) {

        switch(command) {
            case "/exit":
                return Commands.EXIT;
            case "/help":
                return Commands.HELP;
            default:
                return Commands.UNKNOWN;
        }
    }

}
