package hexlet.code;

import java.util.IllegalFormatException;
import java.util.Random;
import java.util.Scanner;

public class Prime {
	private static final int ANSWERS_TO_WIN = 3;
	private static final Random RANDOM = new Random();

	public static void primeGame(User user, Scanner scanner) {

		int correctAnswersCounter = 0;
		System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

		String yes = "yes";
		String no = "no";

		while (correctAnswersCounter < ANSWERS_TO_WIN) {
			int x = RANDOM.nextInt(100) + 1;

			System.out.println("Question: " + x);
			System.out.println("Your answer: ");

			boolean rightAnswer = isPrime(x);
			String yesOrNo = rightAnswer ? "yes" : "no";

			try {
				String userAnswer = scanner.nextLine().trim().toLowerCase();
				if (!userAnswer.equals(yes) && !userAnswer.equals(no)) {
					System.out.println("Please, use only 'yes' or 'no'!)");

				} else {
					if ((userAnswer.equals(yes) && rightAnswer) ||
							(userAnswer.equals(no)) && (!rightAnswer)) {
						correctAnswersCounter++;
						System.out.println("Correct!");
					} else {
						System.out.println(userAnswer + " is wrong answer ;(. Correct answer was '" + yesOrNo + "'.");
						System.out.println("Let's try again, " + user.getName() + "!");
					}
				}
			} catch (IllegalFormatException e) {
				System.out.println("Please, use only 'yes' or 'no'!)");

			}
		}

		System.out.println("Congratulations, " + user.getName() + "!");
		App.repeatGameOffer(scanner, user);
	}


	public static boolean isPrime(int x) {
		if (x <= 1) {
			return false;
		}

		for (int i = 2; i * i < x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
