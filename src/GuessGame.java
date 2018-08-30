/**
 * This class is a number guessing game, where the user guesses a number between 1 and 10.
 * 
 * @author Jacob Plumb 
 * @version 2017.9.14
 */
import java.util.Scanner;
import java.lang.Math;
public class GuessGame{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int guessAmount = 0;
        int randNum = (int)((Math.random() * 10) + 1);
        int userGuess = 0;
        while (userGuess != randNum && guessAmount < 5) {
            System.out.print("Enter a number between 1 and 10: ");
            try {
                String guess = scanner.nextLine();
                userGuess = Integer.parseInt(guess);
                guessAmount++;
                if (userGuess == randNum){
                    System.out.println("You guessed the correct number of " + randNum + " in " + (guessAmount) + " attempts.");
                } else {
                    if (userGuess > randNum) {
                        System.out.println("Oof! You guessed too high.");
                    } else {
                        System.out.println("Oof! You guessed too low.");
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse input. Try again.");
            }

        }
        if (guessAmount == 5 && userGuess != randNum) {
            System.out.println("You couldn't guess it in 5 tries. Better luck next time.");
        }
    }
}