package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calc {

    private static final int ANSWERS_TO_WIN = 3;
    private static final Random RANDOM = new Random();
    private static String USERNAME = "";

    public static void calcGame(Scanner sc) {
        USERNAME = App.greeting(sc);
        System.out.println("What is result of expression?");
        int x = -1;
        int y = -1;
        int correctAnswersCounter = 0; // right answers counter
        while (correctAnswersCounter < ANSWERS_TO_WIN) {
            x = randomNum();
            y = randomNum(x);
            boolean isGamePassed = isGamePassedMethod(sc, x, y);
            if (isGamePassed) {
                correctAnswersCounter++;
            }
            if (isGamePassed && correctAnswersCounter == 3) {
                break;
            }
        }
        System.out.println("Congratulations, " + USERNAME + "!");
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
                System.out.println("Let,s try again, " + USERNAME + "!");
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
                System.out.println("Let,s try again, " + USERNAME + "!");
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
                System.out.println("Let,s try again, " + USERNAME + "!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Text the numbers only");
            return multiplyGame(sc, x, y);
        }
    }

    public static boolean isGamePassedMethod(Scanner sc, int x, int y) {
        int methodNumber = RANDOM.nextInt(3);
        return switch (methodNumber) {
            case 0 -> plusGame(sc, x, y);
            case 1 -> minusGame(sc, x, y);
            case 2 -> multiplyGame(sc, x, y);
            default -> throw new IllegalStateException("Unexpected value: " + methodNumber);
        };
    }
}
