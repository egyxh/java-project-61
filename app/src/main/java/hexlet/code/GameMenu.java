package hexlet.code;
import java.util.List;
import java.util.Scanner;
public final class GameMenu {
    private final List<Game> games = List.of(
            new EvenGame(),
            new CalcGame(),
            new GCDGame(),
            new ProgressionGame(),
            new PrimeGame()
    );
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                return;
            }
            try {
                int choiceNum = Integer.parseInt(choice);
                if (choiceNum == 1) {
                    greetOnly(scanner);
                    return;
                }
                int gameIndex = choiceNum - 2;
                if (gameIndex >= 0 && gameIndex < games.size()) {
                    boolean gameCompleted = new GameEngine(games.get(gameIndex)).run();
                        return;
                } else {
                    System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    private void greetOnly(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    private void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("0 - Exit");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.print("Your choice: ");
    }
}
