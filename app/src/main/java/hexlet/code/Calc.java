package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class Calc {
    private static final int ANSWERS_TO_WIN = 3;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int OPERATIONS_COUNT = 3;
    private static final Random RANDOM = new Random();
    private static String userName = "";
    public static void calcGame(Scanner sc) {
        userName = App.greeting(sc);
        System.out.println("What is the result of the expression?");
        int correctAnswersCounter = 0;
        while (correctAnswersCounter < ANSWERS_TO_WIN) {
            int x = randomNum();
            int y = randomNum(x);
            boolean isGamePassed = isGamePassedMethod(sc, x, y);
            if (isGamePassed) {
                correctAnswersCounter++;
            } else {
                break;
            }
        }
        if (correctAnswersCounter == ANSWERS_TO_WIN) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
    public static int randomNum() {
        return MIN_RANDOM_NUMBER + RANDOM.nextInt(MAX_RANDOM_NUMBER);
    }
    public static int randomNum(int x) {
        int result;
        do {
            result = randomNum();
        } while (x == result);
        return result;
    }
    public static boolean plusGame(Scanner sc, int x, int y) {
        try {
            System.out.println("Question: " + x + " + " + y);
            System.out.println("Your answer: ");
            String answer = sc.nextLine();
            if (Integer.parseInt(answer) == x + y) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println(
                        "'"
                                + answer
                                + "'"
                                + " is wrong answer ;(. Correct answer was '"
                                + (x + y)
                                + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Text the numbers only");
            return plusGame(sc, x, y);
        }
    }
    public static boolean minusGame(Scanner sc, int x, int y) {
        try {
            System.out.println("Question: " + x + " - " + y);
            System.out.println("Your answer: ");
            String answer = sc.nextLine();
            if (Integer.parseInt(answer) == x - y) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println(
                        "'"
                                + answer
                                + "'"
                                + " is wrong answer ;(. Correct answer was '"
                                + (x - y)
                                + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please, use only numbers!)");
            return minusGame(sc, x, y);
        }
    }
    public static boolean multiplyGame(Scanner sc, int x, int y) {
        try {
            System.out.println("Question: " + x + " * " + y);
            System.out.println("Your answer: ");
            String answer = sc.nextLine();
            if (Integer.parseInt(answer) == x * y) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println(
                        "'"
                                + answer
                                + "'"
                                + " is wrong answer ;(. Correct answer was '"
                                + (x * y)
                                + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Text the numbers only");
            return multiplyGame(sc, x, y);
        }
    }
    public static boolean isGamePassedMethod(Scanner sc, int x, int y) {
        int methodNumber = RANDOM.nextInt(OPERATIONS_COUNT);
        return switch (methodNumber) {
            case 0 -> plusGame(sc, x, y);
            case 1 -> minusGame(sc, x, y);
            case 2 -> multiplyGame(sc, x, y);
            default -> throw new IllegalStateException("Unexpected value: " + methodNumber);
        };
    }
}
