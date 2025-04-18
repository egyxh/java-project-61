package hexlet.code;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Progression {
	private static final int ANSWERS_TO_WIN = 3;
	private static final Random RANDOM = new Random();

	public static void progressionGame(User user, Scanner scanner) {

		int correctAnswersCounter = 0;
		System.out.println("What number is missing in the progression?");

		while (correctAnswersCounter < ANSWERS_TO_WIN) {
			int[] arr = randomArray();
			int indexOfHiddenNum = RANDOM.nextInt(10);

			System.out.println("Question: ");
			for (int i = 0; i < arr.length; i++) {
				if (i == indexOfHiddenNum) {
					System.out.print(".. ");
				} else {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println("Your answer: ");
			String answer = scanner.nextLine().trim();
			try {
				int userAnswer = Integer.parseInt(answer);
				int correctAnswer = arr[indexOfHiddenNum];

				if (userAnswer == correctAnswer) {
					correctAnswersCounter++;
					System.out.println("Correct!");
				} else {
					System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
							+ correctAnswer + "'.");
					System.out.println("Let's try again, " + user.getName() + "!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please, use only numbers!)");
			}

		}

		System.out.println("Congratulations, " + user.getName() + "!");
		App.repeatGameOffer(scanner, user);
	}

	public static int[] randomArray() {
		int firstNum = RANDOM.nextInt(50) + 1;
		int stepOfProgression = RANDOM.nextInt(10) + 1;

		int[] randomProgression = new int[10];

		for (int i = 0; i < randomProgression.length; i++) {
			randomProgression[i] = firstNum + i * stepOfProgression;
		}
		return randomProgression;
	}
}
