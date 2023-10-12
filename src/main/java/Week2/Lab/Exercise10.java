package Week2.Lab;

import java.util.Scanner;
import java.util.Random;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100);
        int guesses = 0;

        while (true) {
            System.out.print("Guess a number: ");
            int guess = Integer.parseInt(reader.nextLine());
            guesses++;
            if (guess == number) {
                System.out.println("Congratulations, your guess is correct!");
                break;
            } else if (guess < number) {
                System.out.println("The number is greater, guesses made: " + guesses);
            } else {
                System.out.println("The number is lesser, guesses made: " + guesses);
            }
        }
    }
}
