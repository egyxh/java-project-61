package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.QuestionAnswer;
import hexlet.code.Utils;
public final class ProgressionGame implements Game {
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
        int start = Utils.generateNumber(1, MAX_FIRST_NUMBER);
        int step = Utils.generateNumber(1, MAX_STEP);
        int hiddenIndex = Utils.generateNumber(1, PROGRESSION_LENGTH);
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
