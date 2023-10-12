package Week2.Lab;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        // Create a program that asks the user for three numbers and then prints their sum.

        Scanner reader = new Scanner(System.in);
        int sum = 0;
        int read;

        // WRITE YOUR PROGRAM HERE
        // USE ONLY THE VARIABLES sum, reader AND read!

        for (int i = 0; i < 3; i++) {
            System.out.print("Type the first number: ");
            read = Integer.parseInt(reader.nextLine());
            sum += read;
        }
        System.out.println();

        System.out.println("Sum: " + sum);
    }
}
