//©Jiyon Chatterjee's Number Guess Game Refactor, 2023
import java.util.Scanner;
import java.util.ArrayList;

public class RunNumberGuessGame {
     int lowerBound;
     int upperBound;
     int correct;
     ArrayList<Integer> guesses;
     int guessCount;

    public RunNumberGuessGame(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.correct = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        this.guesses = new ArrayList<>();
        this.guessCount = 0;
    }

    public void playGame(Scanner scanner, String difficulty) { 
        if (difficulty.equals("easy")) { //sets difficulties
            upperBound = upperBound + 10;
        } else if (difficulty.equals("medium")) {
            upperBound = upperBound + 5;
        }

        while (true) {
            System.out.print("Enter your guess please: ");
            int guess = errorCheck(scanner);
            if (guesses.contains(guess)) { //doesn't count if repeated guess
                System.out.println("You already guessed that number. Please try again.");
            } else { //adds guess to Array List and counts it
                guesses.add(guess);
                guessCount++;
                if (guess == correct) {
                    System.out.println("Congrats pal! You guessed the correct number in " + guessCount + " tries.");
                    break;
                } else if (guess < correct) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }
            }
        }
    }

    private static int errorCheck(Scanner scanner) { //error checking method
        while (!scanner.hasNextInt()) {
            System.out.print("That's an invalid input. Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) { //makes user enter range for guess game
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the lower bound of the number guess range: ");
            int lowerBound = errorCheck(scanner);
            System.out.print("Enter the upper bound of the number guess range: ");
            int upperBound = errorCheck(scanner);
            System.out.print("Choose difficulty level (easy, medium, or hard): ");
            String difficulty = scanner.next();

            RunNumberGuessGame game = new RunNumberGuessGame(lowerBound, upperBound);
            game.playGame(scanner, difficulty);

            System.out.print("Do you want to play again? (yes/no): "); //makes game replayable
            String playAgain = scanner.next();
            if (playAgain.equals("no")) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
}