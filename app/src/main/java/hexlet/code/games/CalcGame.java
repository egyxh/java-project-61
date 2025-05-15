package hexlet.code.games;
import hexlet.code.Game;
import hexlet.code.QuestionAnswer;
import hexlet.code.Utils;
public final class CalcGame implements Game {
    private static final int MAX_NUMBER = 100;
    private final String[] operations = {"+", "-", "*"};
    public String getName() {
        return "Calc";
    }
    public String getRules() {
        return "What is the result of the expression?";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int a = Utils.generateNumber(1, MAX_NUMBER);
        int b = Utils.generateNumber(1, MAX_NUMBER);
        String operation = operations[Utils.generateNumber(0, operations.length)];
        return new QuestionAnswer(
                a + " " + operation + " " + b,
                Integer.toString(calculate(a, b, operation))
        );
    }
    private int calculate(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }
}
