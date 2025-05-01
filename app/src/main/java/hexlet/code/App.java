package hexlet.code;

import java.util.Scanner;

import lombok.Getter;

public class App {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gameChooser(sc);
    }
    
    public static String greeting(Scanner sc) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
    
    public static void gameChooser(Scanner sc) {
        while (true) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("0 - Exit");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("Your choice: ");
            String numOfGame = sc.nextLine()
                    .trim();
            if (!numOfGame.matches("[0-6]")) {
                System.out.println("Допустимые значения: 0, 1, 2, 3, 4, 5, 6");
                continue;
            }
            if (numOfGame.equals("1")) {
                greeting(sc);
                return;
            }
            if (numOfGame.equals("0")) {
                return;
            }
            for (Games game : Games.values()) {
                if (numOfGame.equals(game.getGameNum())) {
                    game.launchGame(sc);
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
        
        @Getter
        private final String gameNum;
        private final GameLauncher gameLauncher;
        
        Games(final String number, final GameLauncher launcher) {
            this.gameNum = number;
            this.gameLauncher = launcher;
        }
        
        public void launchGame(Scanner sc) {
            gameLauncher.launch(sc);
        }
        
        @FunctionalInterface
        private interface GameLauncher {
            
            void launch(Scanner sc);
        }
    }
}
