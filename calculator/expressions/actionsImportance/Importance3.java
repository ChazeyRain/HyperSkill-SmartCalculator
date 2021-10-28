package calculator.expressions.actionsImportance;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Importance3 {

    private static final Pattern subtraction = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?-\\d+(\\.\\d+)?");
    private static final Pattern addition = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?\\+(\\+|-)?\\d+(\\.\\d+)?");


    static String calculate(String expression) {

        expression = AbstractAction.action("+", addition, expression,
                BigDecimal::add);
        expression = AbstractAction.action("-", subtraction, expression,
                BigDecimal::subtract);



        return expression;
    }


}
