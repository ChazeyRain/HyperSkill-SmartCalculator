package calculator.expressions.actionsImportance;

import java.util.regex.Pattern;

public class Importance1 {
    private static final Pattern power = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?\\^(\\+|-)?\\d+(\\.\\d+)?");


    static String calculate(String expression) {

        expression = AbstractAction.action("^", power, expression,
                (x, y) -> {
                    int pow = y.intValueExact();
                    return x.pow(pow);
                });

        return Importance2.calculate(expression);
    }
}
