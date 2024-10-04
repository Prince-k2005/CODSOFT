import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 10;
    private static int totalRounds = 0;
    private static int totalWins = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playRound(scanner);
            totalRounds++;
            
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.printf("\nGame Over! You played %d round(s) and won %d time(s).\n", totalRounds, totalWins);
        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("\nGuess the number between 1 and 100. You have 10 attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low.");
            } else if (guess > secretNumber) {
                System.out.println("Too high.");
            } else {
                System.out.printf("Congratulations! You've guessed the number %d in %d attempts.\n", secretNumber, attempts);
                totalWins++;
                hasGuessedCorrectly = true;
                break;
            }

            System.out.printf("You have %d attempt(s) remaining.\n", MAX_ATTEMPTS - attempts);
        }

        if (!hasGuessedCorrectly) {
            System.out.printf("Sorry, you've run out of attempts. The number was %d.\n", secretNumber);
        }
    }
}
