package calculator.commands;

public enum Commands {
    EXIT(false, "Bye!"),
    HELP(true, "The program can sum, subtract, divide and multiply"),
    UNKNOWN(true, "Unknown command");

    private final boolean shouldRun;
    private final String message;

    Commands(boolean shouldRun, String message) {
        this.message = message;
        this.shouldRun = shouldRun;
    }

    public boolean shouldRun() {
        return shouldRun;
    }

    @Override
    public String toString() {
        return message;
    }
}
