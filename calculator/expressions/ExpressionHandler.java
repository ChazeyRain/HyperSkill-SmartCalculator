package calculator.expressions;

public class ExpressionHandler {


    public static String handle(String expression) {

        if (expression.matches(".*\\d+ \\d+.*|.*[^0-9)]$")) {
            return null;
        }

        String result = ExpressionCalculate.start(expression);

        if (result == null || !result.matches("-?\\d+(\\.\\d+)?")) {
            return null;
        }

        return result;
    }

}
