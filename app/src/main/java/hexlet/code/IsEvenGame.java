package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class IsEvenGame {
    
    private static final int ANSWERS_TO_WIN = 3;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final Random RANDOM = new Random();
    private static String userName = "";
    
    public static void runGameOne(Scanner sc) {
        userName = App.greeting(sc);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int correctAnswersCounter = 0;
        int j = 0;
        String y = "yes";
        String n = "no";
        while (correctAnswersCounter < ANSWERS_TO_WIN) {
            int i = randomNum(j);
            System.out.println("Question: " + i);
            String answer = sc.nextLine();
            if (answer.trim()
                    .toLowerCase()
                    .equals(y)) {
                if (i % 2 == 0) {
                    correctAnswersCounter++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            } else if (answer.trim()
                    .toLowerCase()
                    .equals(n)) {
                if (i % 2 != 0) {
                    correctAnswersCounter++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            } else {
                System.out.println("Please, use only 'yes' or 'no' !)");
            }
            j = i;
        }
        if (correctAnswersCounter != 3) {
            return;
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    
    public static int randomNum() {
        return 1 + RANDOM.nextInt(MAX_RANDOM_NUMBER);
    }
    
    public static int randomNum(int x) {
        int result;
        do {
            result = randomNum();
        } while (x == result);
        return result;
    }
}
