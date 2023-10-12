package Week2.Lab;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum = 0;

        System.out.print("Type a number: ");
        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i <= n; i++) {
            int result = (int) Math.pow(2, i);
            sum += result;
        }
        System.out.println("The result is " + sum);
    }
}
