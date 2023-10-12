package Week1.Lecture;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class ClassCalculator {
    public static void main(String[] args) {
        while (true) {
            List<String> choices = Arrays.asList("sum", "difference", "quit");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter one of the choices (sum, difference, quit): ");
            String userChoice = scanner.nextLine();

            if (choices.contains(userChoice)) {

                if (userChoice.equals("quit")) {
                    System.out.println("We're sorry to see you go :(");
                    break;
                }

                System.out.println("Enter first number ");
                int firstNumber = scanner.nextInt();

                System.out.println("Enter second number ");
                int secondNumber = scanner.nextInt();

                if (userChoice.equals("sum")) {
                    System.out.println("The result is " + (firstNumber + secondNumber));
                    break;
                }

                System.out.println("The result is " + (firstNumber - secondNumber));
                break;
            }
        }
    }
}
