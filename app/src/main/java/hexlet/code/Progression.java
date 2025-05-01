package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class Progression {
    private static final int ANSWERS_TO_WIN = 3;
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_FIRST_NUMBER = 50;
    private static final int MAX_STEP = 10;
    private static final int MAX_INDEX_OF_HIDDEN_NUMBER = 10;
    private static final Random RANDOM = new Random();
    private static String userName = "";
    public static void progressionGame(Scanner scanner) {
        userName = App.greeting(scanner);
        int correctAnswersCounter = 0;
        System.out.println("What number is missing in the progression?");
        while (correctAnswersCounter < ANSWERS_TO_WIN) {
            int[] arr = randomArray();
            int indexOfHiddenNum = RANDOM.nextInt(MAX_INDEX_OF_HIDDEN_NUMBER);
            System.out.print("Question: ");
            for (int i = 0; i < arr.length; i++) {
                if (i == indexOfHiddenNum) {
                    System.out.print(".. ");
                } else {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.print("\n" + "Your answer: ");
            String answer = scanner.nextLine()
                    .trim();
            try {
                int userAnswer = Integer.parseInt(answer);
                int correctAnswer = arr[indexOfHiddenNum];
                if (userAnswer == correctAnswer) {
                    correctAnswersCounter++;
                    System.out.println("Correct!");
                } else {
                    System.out.println(
                            "'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                    System.out.println("Let's try again, " + userName + "!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please, use only numbers!)");
            }
        }
        if (correctAnswersCounter != ANSWERS_TO_WIN) {
            return;
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    public static int[] randomArray() {
        int firstNum = RANDOM.nextInt(MAX_FIRST_NUMBER) + 1;
        int stepOfProgression = RANDOM.nextInt(MAX_STEP) + 1;
        int[] randomProgression = new int[PROGRESSION_LENGTH];
        for (int i = 0; i < randomProgression.length; i++) {
            randomProgression[i] = firstNum + i * stepOfProgression;
        }
        return randomProgression;
    }
}
