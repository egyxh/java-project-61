package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAnswer;
import hexlet.code.Utils;
public final class PrimeGame implements Game {
    private static final int MAX_NUMBER = 100;
    public String getName() {
        return "Prime";
    }
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int number = Utils.generateNumber(1, MAX_NUMBER);
        return new QuestionAnswer(Integer.toString(number), isPrime(number) ? "yes" : "no");
    }
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
