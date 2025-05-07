package hexlet.games;
import hexlet.code.*;
public final class EvenGame implements Game {
    private static final int MAX_NUMBER = 100;
    public String getName() {
        return "Even";
    }
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int number = Utils.generateNumber(1, MAX_NUMBER);
        String correctAnswer = number % 2 == 0 ? "yes" : "no";
        return new QuestionAnswer(Integer.toString(number), correctAnswer);
    }
}
