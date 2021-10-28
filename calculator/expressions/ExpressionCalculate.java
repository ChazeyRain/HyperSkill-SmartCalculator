package calculator.expressions;

import calculator.expressions.actionsImportance.Importance0;

public class ExpressionCalculate {

    static String start(String expression) {

        expression = expression.replaceAll("\\s+", "");
        expression = expression.replaceAll("\\++", "+");
        expression = expression.replaceAll("(--)+", "+");
        expression = expression.replaceAll("\\+-", "-");

        try {
            String result = Importance0.calculate(expression);
            return result.replaceFirst("\\+", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
