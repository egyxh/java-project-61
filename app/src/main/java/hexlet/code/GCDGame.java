package hexlet.code;

import java.util.Random;

public class GCDGame implements Game {
    private final Random random = new Random();
    private final int MAX_NUMBER = 100;
    
    public String getName() {
        return "GCD";
    }
    
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    
    public QuestionAnswer generateQuestionAnswer() {
        int a = random.nextInt(MAX_NUMBER) + 1;
        int b = random.nextInt(MAX_NUMBER) + 1;
        return new QuestionAnswer(a + " " + b, Integer.toString(gcd(a, b)));
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
