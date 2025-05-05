package hexlet.code;
import java.util.Scanner;
public final class GameEngine {
    private static final int ROUNDS_TO_WIN = 3;
    private final Scanner scanner = new Scanner(System.in);
    private final Game game;
    private String userName;
    public GameEngine(Game currentGame) {
        this.game = currentGame;
    }
    public boolean run() {
        greetUser();
        System.out.println(game.getRules());
        int correctAnswers = 0;
        while (correctAnswers < ROUNDS_TO_WIN) {
            QuestionAnswer qa = game.generateQuestionAnswer();
            System.out.println("Question: " + qa.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();
            if (userAnswer.equals(qa.getCorrectAnswer())) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + qa.getCorrectAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return false;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        return true;
    }
    private void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
