package hexlet.code;
public final class QuestionAnswer {
    private final String question;
    private final String correctAnswer;
    public QuestionAnswer(String currentQuestion, String currentCorrectAnswer) {
        this.question = currentQuestion;
        this.correctAnswer = currentCorrectAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
