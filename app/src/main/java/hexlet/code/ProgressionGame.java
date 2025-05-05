package hexlet.code;
import java.util.Random;
public final class ProgressionGame implements Game {
    private final Random random = new Random();
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_FIRST_NUMBER = 50;
    private static final int MAX_STEP = 10;
    public String getName() {
        return "Progression";
    }
    public String getRules() {
        return "What number is missing in the progression?";
    }
    public QuestionAnswer generateQuestionAnswer() {
        int start = random.nextInt(MAX_FIRST_NUMBER) + 1;
        int step = random.nextInt(MAX_STEP) + 1;
        int hiddenIndex = random.nextInt(PROGRESSION_LENGTH);
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(start + step * i).append(" ");
            }
        }
        int correctAnswer = start + step * hiddenIndex;
        return new QuestionAnswer(question.toString().trim(), Integer.toString(correctAnswer));
    }
}
