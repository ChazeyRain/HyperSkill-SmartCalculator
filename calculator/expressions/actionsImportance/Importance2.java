package calculator.expressions.actionsImportance;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.regex.Pattern;

public class Importance2 {

    private static final Pattern division = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?/(\\+|-)?\\d+(\\.\\d+)?");
    private static final Pattern multiplication = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?\\*(\\+|-)?\\d+(\\.\\d+)?");


    static String calculate(String expression) {

        expression = AbstractAction.action("*", multiplication, expression,
                BigDecimal::multiply);
        expression = AbstractAction.action("/", division, expression,
                (x, y) -> x.divide(y, MathContext.DECIMAL128));

        return Importance3.calculate(expression);
    }

}
