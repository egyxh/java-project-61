package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Gcd {
    
    private static final int ANSWERS_TO_WIN = 3;
    private static final Random RANDOM = new Random();
    private static String USERNAME = "";
    
    public static void gcdGame(Scanner sc) {
        USERNAME = App.greeting(sc);
        int correctAnswers = 0;
        System.out.println("Find the greatest common divisor of given numbers.");
        while (correctAnswers < ANSWERS_TO_WIN) {
            int x = randomNum();
            int y = randomNum(x);
            System.out.println("Question: " + x + " " + y);
            System.out.println("Your answer: ");
            String answer = sc.nextLine();
            try {
                int userAnswer = Integer.parseInt(answer);
                int correctAnswer = gcdFinder(x, y);
                if (userAnswer == correctAnswer) {
                    correctAnswers++;
                    System.out.println("Correct!");
                } else {
                    System.out.println(
                            "'"
                                    + answer
                                    + "' "
                                    + "is wrong answer ;(. Correct answer was '"
                                    + correctAnswer
                                    + "'.");
                    System.out.println("Let's try again, " + USERNAME + "!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please, use only numbers!)");
            }
        }
        if (correctAnswers != 3) {
            return;
        }
        System.out.println("Congratulations, " + USERNAME + "!");
    }
    
    public static int gcdFinder(int x, int y) {
        if (y == 0) {
            return Math.abs(x);
        } else {
            return gcdFinder(y, (x % y));
        }
    }
    
    public static int randomNum() {
        return 1 + RANDOM.nextInt(100);
    }
    
    public static int randomNum(int x) {
        int result;
        do {
            result = randomNum();
        } while (x == result);
        return result;
    }
}
