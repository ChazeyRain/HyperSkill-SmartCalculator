package calculator.variables;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Variables {

    private static final Map<String, String> variableMap = new HashMap<>();
    private static final Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final Pattern varNamePattern = Pattern.compile("[A-Za-z]+");

    public static AssignmentStatus assign(String input) {
        input = input.replaceAll("\\s+", "");

        String[] inputs = input.split("=");
        String number = inputs[1];
        String varName = inputs[0];

        Matcher numberMatcher = numberPattern.matcher(number);
        Matcher varNameMatcher = varNamePattern.matcher(varName);

        if (!varNameMatcher.matches()) {
            return AssignmentStatus.INVALID_IDENTIFIER;
        }

        varNameMatcher = varNamePattern.matcher(number);
        if (inputs.length != 2 ||
                (!numberMatcher.matches() && !varNameMatcher.matches())) {
            return AssignmentStatus.INVALID_ASSIGNMENT;
        }

        if (numberMatcher.matches()) {
            variableMap.put(varName, number);
            return AssignmentStatus.OK;
        }

        String n = variableMap.getOrDefault(number,null);

        if (n != null) {
            variableMap.put(varName, n);
            return AssignmentStatus.OK;
        }

        return AssignmentStatus.UNKNOWN_VARIABLE;
    }

    public static String insertNumbers(String expression) {
        String newExpression = expression;

        Set<String> variables = variableMap.keySet();

        for (String var : variables) {
            newExpression = newExpression.replaceAll("\\b" + var + "\\b",
                    variableMap.get(var));
        }

        Pattern varPattern = Pattern.compile("\\b[A-Za-z]+\\b(?!\\()");
        Matcher varMatcher = varPattern.matcher(newExpression);

        if (varMatcher.find()) {
            return null;
        }

        return newExpression;
    }

}
