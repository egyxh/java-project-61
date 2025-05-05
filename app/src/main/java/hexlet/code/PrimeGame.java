package hexlet.code;
import java.util.Random;
public final class PrimeGame implements Game {
    private final Random random = new Random();
    private static final int MAX_NUMBER = 100;
    public String getName() {
        return "Prime";
    }
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int number = random.nextInt(MAX_NUMBER) + 1;
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
