package hexlet.code;
public class QuestionAnswer {
    private final String question;
    private final String correctAnswer;
    public QuestionAnswer(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
