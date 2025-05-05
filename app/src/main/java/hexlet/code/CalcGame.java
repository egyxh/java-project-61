package hexlet.code;
import java.util.Random;
public final class CalcGame implements Game {
    private final Random random = new Random();
    private static final int MAX_NUMBER = 100;
    private final String[] operations = {"+", "-", "*"};
    public String getName() {
        return "Calc";
    }
    public String getRules() {
        return "What is the result of the expression?";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int a = random.nextInt(MAX_NUMBER) + 1;
        int b = random.nextInt(MAX_NUMBER) + 1;
        String operation = operations[random.nextInt(operations.length)];
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
