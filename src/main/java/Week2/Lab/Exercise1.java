package Week2.Lab;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        // Create a program that asks the user for a password.
        // If the password is right, a secret message is shown to the user.

        Scanner reader = new Scanner(System.in);
        String secret_message = "jryy qbar!", guess, password = "carrot";

        while (true) {
            System.out.print("Type the password: ");
            guess = reader.nextLine();
            if (guess.equals(password)) {
                System.out.println("Right!\n");
                break;
            } else {
                System.out.println("Wrong!");
            }
        }
        System.out.println("The secret is: ".concat(secret_message));
    }
}
