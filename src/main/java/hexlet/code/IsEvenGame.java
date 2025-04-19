package hexlet.code;

import java.util.Scanner;

public class IsEvenGame {
	public static void runGameOne(User currentUser, Scanner sc) {
		System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

		int x = 0; // right answers counter
		int z = 0; // non-repeat num checker

		String y = "yes";
		String n = "no";

		while (x < 3) {

			int i = (int) (Math.random() * 100 - 1);
			if (i == z) {
				i = i * 3 / 2;
			}
			System.out.println("Question: " + i);
			String answer = sc.nextLine();

			if (answer.trim().toLowerCase().equals(y)) {
				if (i % 2 == 0) {
					x++;
					System.out.println("Correct!");
				} else {
					System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'");
					System.out.println("Let's try again, " + currentUser.getName() + "1");
				}
			} else if (answer.trim().toLowerCase().equals(n)) {
				if (i % 2 != 0) {
					x++;
					System.out.println("Correct!");
				} else {
					System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'");
					System.out.println("Let's try again, " + currentUser.getName() + "!");
				}
			} else {
				System.out.println("Please, use only 'yes' or 'no' !)");
			}
			z = i;
		}
		System.out.println("Congratulations, " + currentUser.getName() + "!");
		App.repeatGameOffer(sc, currentUser);
	}

}
