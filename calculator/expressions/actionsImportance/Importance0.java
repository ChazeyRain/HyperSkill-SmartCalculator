package calculator.expressions.actionsImportance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Importance0 {

    private static final Pattern parentheses = Pattern.compile("\\([^()]*\\)");


    public static String calculate(String expression) {

        while (true) {
            Matcher parenthesesMatcher = parentheses.matcher(expression);

            if (!parenthesesMatcher.find()) {
                break;
            }

            String subExpression = parenthesesMatcher.group(0);
            String number = Importance2.calculate(subExpression.substring(1, subExpression.length() - 1));

            expression = parenthesesMatcher.replaceFirst(number);
        }

        return Importance1.calculate(expression);
    }


}
