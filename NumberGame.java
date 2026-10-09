import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Game settings
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7; // Limit the number of attempts
        
        // Score tracking
        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("✨ Welcome to the Number Guessing Game! ✨");

        while (playAgain) {
            totalRounds++;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsTaken = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!");

            // Turn loop for the current round
            while (attemptsTaken < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                // Input validation to prevent crashes if input is not an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input. Please enter a valid number.");
                    System.out.print("Enter your guess: ");
                    scanner.next();
                }
                
                int userGuess = scanner.nextInt();
                attemptsTaken++;

                // Compare the guess with the generated number
                if (userGuess == randomNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number in " + attemptsTaken + " attempts.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("📉 Too low! Try a higher number. (" + (maxAttempts - attemptsTaken) + " attempts left)");
                } else {
                    System.out.println("📈 Too high! Try a lower number. (" + (maxAttempts - attemptsTaken) + " attempts left)");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("\n😢 Game Over for this round! You've run out of attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            // Display current scoreboard
            System.out.println("\n📊 Current Score -> Rounds Won: " + roundsWon + " / Total Rounds: " + totalRounds);

            // Ask the user to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        // Final exit messages
        System.out.println("\n🏁 Thank you for playing!");
        System.out.println("Final Scoreboard -> Total Rounds: " + totalRounds + " | Rounds Won: " + roundsWon);
        scanner.close();
    }
}
