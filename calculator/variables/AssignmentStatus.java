package calculator.variables;

public enum AssignmentStatus {
    INVALID_IDENTIFIER("Invalid identifier"),
    INVALID_ASSIGNMENT("Invalid assignment"),
    UNKNOWN_VARIABLE("Unknown variable"),
    OK("Ok");

    final String status;

    AssignmentStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
