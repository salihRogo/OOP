package Week2.Lecture;

import java.util.Scanner;

public class ClassAge {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int age = Integer.parseInt(reader.nextLine());

        while (true) {
            if (age < 3 || age > 125) {
                System.out.println("You are a little liar.");
                if (age < 3) {
                    System.out.println("You are too young to write and read!");
                } else {
                    System.out.println("Go die!");
                }
                System.out.println("Please enter your age again. This time without lying: ");
                age = Integer.parseInt(reader.nextLine());
                continue;
            }
            break;
        }
        System.out.println("You are " + age + " years old.");
    }
}
