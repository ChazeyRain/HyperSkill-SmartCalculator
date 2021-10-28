package calculator.expressions.actionsImportance;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AbstractAction {

    static String action(String sign,
                         Pattern pattern,
                         String expression,
                         BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {

        while (true) {
            Matcher parenthesesMatcher = pattern.matcher(expression);

            if (!parenthesesMatcher.find()) {
                break;
            }

            String subExpression = parenthesesMatcher.group(0);
            int signIndex = subExpression.lastIndexOf(sign);

            BigDecimal number1 = new BigDecimal(subExpression.substring(0, signIndex));
            BigDecimal number2 = new BigDecimal(subExpression.substring(signIndex + 1));

            expression = parenthesesMatcher.replaceFirst("+" + function.apply(number1, number2).toString());
            expression = expression.replaceAll("\\+-|-\\+", "-");
        }

        return expression;
    }

}
