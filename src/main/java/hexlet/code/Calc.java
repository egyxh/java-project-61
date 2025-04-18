package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calc {
	public static void calcGame(User currentUser, Scanner sc) {
		System.out.println("What is result of expression?");
		int x = -1;
		int y = -1;
		int counter = 0; // right answers counter


		while (counter < 3) {

			x = randNums(x);
			y = randNums(x);

			boolean isGamePassed = isGamePassedMethod(currentUser, sc, x, y);
			if (isGamePassed) {
				counter++;
			}
			if (isGamePassed && counter == 3) {
				break;
			}
		}

		System.out.println("Congratulations, " + currentUser.getName() + "!");
		App.repeatGameOffer(sc, currentUser);
	}


	public static int randNums(int x) {
		int i = 0;

		do {
			i = (int) (Math.random() * 100);
		} while (i == x && x >= 0);
		return i;
	}


	public static boolean plusGame(User currentUser, Scanner sc, int x, int y) {

		try {
			System.out.println("Question: " + x + " + " + y);
			System.out.println("Your answer: ");
			String answer = sc.nextLine();
			if (Integer.parseInt(answer) == x + y) {
				System.out.println("Correct!");
				return true;
			} else {
				System.out.println("'" + answer + "'"
						+ " is wrong answer ;(. Correct answer was '" + (x + y) + "'.");
				System.out.println("Let,s try again, " + currentUser.getName() + "!");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Text the numbers only");
			return plusGame(currentUser, sc, x, y);
		}
	}

	public static boolean minusGame(User currentUser, Scanner sc, int x, int y) {

		try {
			System.out.println("Question: " + x + " - " + y);
			System.out.println("Your answer: ");
			String answer = sc.nextLine();
			if (Integer.parseInt(answer) == x - y) {
				System.out.println("Correct!");
				return true;
			} else {
				System.out.println("'" + answer + "'"
						+ " is wrong answer ;(. Correct answer was '" + (x - y) + "'.");
				System.out.println("Let,s try again, " + currentUser.getName() + "!");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Please, use only numbers!)");
			return minusGame(currentUser, sc, x, y);
		}
	}

	public static boolean multiplyGame(User currentUser, Scanner sc, int x, int y) {

		try {
			System.out.println("Question: " + x + " * " + y);
			System.out.println("Your answer: ");
			String answer = sc.nextLine();
			if (Integer.parseInt(answer) == x * y) {
				System.out.println("Correct!");
				return true;
			} else {
				System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was '" + (x * y) + "'.");
				System.out.println("Let,s try again, " + currentUser.getName() + "!");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Text the numbers only");
			return multiplyGame(currentUser, sc, x, y);
		}
	}

	public static boolean isGamePassedMethod(User currentUser, Scanner sc, int x, int y) {
		Random random = new Random();
		int methodNumber = random.nextInt(3);

		return switch (methodNumber) {
			case 0 -> plusGame(currentUser, sc, x, y);
			case 1 -> minusGame(currentUser, sc, x, y);
			case 2 -> multiplyGame(currentUser, sc, x, y);
			default -> throw new IllegalStateException("Unexpected value: " + methodNumber);
		};
	}
}
