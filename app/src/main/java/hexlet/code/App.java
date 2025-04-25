package hexlet.code;

import java.util.Scanner;
import lombok.Getter;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User currentUser = greeting(sc);
        gameChooser(currentUser, sc);
    }

    public static User greeting(Scanner sc) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.nextLine();
        User currentUser = new User(userName);
        System.out.println("Hello, " + userName + "!");
        return currentUser;
    }

    public static void gameChooser(User us, Scanner sc) {
        while (true) {
            System.out.println("0 - Exit");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("Enter the number of game to play");
            String numOfGame = sc.nextLine().trim();
            if (!numOfGame.matches("[0-6]")) {
                System.out.println("Допустимые значения: 0, 1, 2, 3, 4, 6");
                continue;
            }
            if (numOfGame.equals("1")) {
                greeting(sc);
            }
            if (numOfGame.equals("0")) {
                System.out.println("Goodbye " + us.getName() + "!");
                return;
            }
            for (Games game : Games.values()) {
                if (numOfGame.equals(game.getGameNum())) {
                    game.launchGame(us, sc);
                    return;
                }
            }
        }
    }

    enum Games {
        EVEN("2", IsEvenGame::runGameOne),
        CALC("3", Calc::calcGame),
        GCD("4", Gcd::gcdGame),
        PROGRESSION("5", Progression::progressionGame),
        PRIME("6", Prime::primeGame);

        @Getter private final String gameNum;
        private final GameLauncher gl;

        Games(String gameNum, GameLauncher gl) {
            this.gameNum = gameNum;
            this.gl = gl;
        }

        public void launchGame(User u, Scanner sc) {
            gl.launch(u, sc);
        }

        @FunctionalInterface
        private interface GameLauncher {

            void launch(User user, Scanner sc);
        }
    }

    public static void repeatGameOffer(Scanner sc, User currentUser) {
        System.out.println("Wanna play again???");
        System.out.println("Yes / No");
        String answer = sc.nextLine().trim().toLowerCase();
        if (answer.equals("yes")) {
            App.gameChooser(currentUser, sc);
        } else if (answer.equals("no")) {
            System.out.println("Goodbye, " + currentUser.getName() + "!");
        } else {
            System.out.println("I will consider this as YES ;)");
            App.gameChooser(currentUser, sc);
        }
    }
}
