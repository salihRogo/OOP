package Week1.Lab;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type a number: ");
        int num1 = Integer.parseInt(reader.nextLine());
        System.out.print("Type another number: ");
        int num2 = Integer.parseInt(reader.nextLine());

        System.out.print("\n");

        System.out.println("Sum of the numbers: " + (num1 + num2));
    }
}
