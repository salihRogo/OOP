package Week2.Lab;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        // Create a program that asks the user for the first number and the last number and then prints all numbers between those two.
        // Use a while loop.
        // If the first number is greater than the last number, the program prints nothing.

        Scanner reader = new Scanner(System.in);
        int first, second;

        System.out.print("First: ");
        first = Integer.parseInt(reader.nextLine());

        System.out.print("Second: ");
        second = Integer.parseInt(reader.nextLine());

        if (first < second) {
            while (first <= second) {
                System.out.println(first);
                first++;
            }
        }
    }
}
