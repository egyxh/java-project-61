package hexlet.code;

import java.util.Random;

public class EvenGame implements Game {
    private final Random random = new Random();
    private final int MAX_NUMBER = 100;
    
    public String getName() {
        return "Even";
    }
    
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    
    public QuestionAnswer generateQuestionAnswer() {
        int number = random.nextInt(MAX_NUMBER) + 1;
        String correctAnswer = number % 2 == 0 ? "yes" : "no";
        return new QuestionAnswer(Integer.toString(number), correctAnswer);
    }
}
