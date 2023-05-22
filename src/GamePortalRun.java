import java.util.Scanner;

public class GamePortalRun {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Game Portal!");
            System.out.println("Please choose a game to play:");
            System.out.println("1. Which Apocalypse Are You?");
            System.out.println("2. Number Guessing Game");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    playApocalypseQuiz(scanner);
                    break;
                case 2:
                    playNumberGuessingGame(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for playing!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void playApocalypseQuiz(Scanner scanner) throws Exception {
        Quiz.main(null);

        scanner.nextLine();
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    public static void playNumberGuessingGame(Scanner scanner) {

        RunNumberGuessGame.main(null);

        scanner.nextLine();
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}
