package Week2.Lab;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        // Create a method printText that prints the following string of characters:
        // "In the beginning there were the swamp, the hoe and Java." and a line break.
        Scanner reader = new Scanner(System.in);
        System.out.print("How many times you want the text to be printed: ");
        int n = Integer.parseInt(reader.nextLine());
        printText(n);
    }

    public static void printText(int number) {
        // WRITE YOUR CODE HERE
        int i = 0;
        while (i < number) {
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
            i++;
        }
    }
}
