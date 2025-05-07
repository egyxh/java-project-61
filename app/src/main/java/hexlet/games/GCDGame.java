package hexlet.games;
import hexlet.code.Game;
import hexlet.code.QuestionAnswer;
import hexlet.code.Utils;
public final class GCDGame implements Game {
    private static final int MAX_NUMBER = 100;
    public String getName() {
        return "GCD";
    }
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int a = Utils.generateNumber(1, MAX_NUMBER);
        int b = Utils.generateNumber(1, MAX_NUMBER);
        return new QuestionAnswer(a + " " + b, Integer.toString(gcd(a, b)));
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
