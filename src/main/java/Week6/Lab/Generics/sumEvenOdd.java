package Week6.Lab.Generics;

import java.util.List;

public class sumEvenOdd {
    public static < T extends Number > void calculateSum(List<T> numbers) {
        double sumOfEven = 0;
        double sumOfOdd = 0;

        for (T number : numbers) {
            if ( number.doubleValue() % 2 == 0) {
                sumOfEven += number.doubleValue();
            } else {
                sumOfOdd += number.doubleValue();
            }
        }

        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Sum of even numbers: " + sumOfEven);
        System.out.println("Sum of odd numbers: " + sumOfOdd);
    }

    public static void main(String[] args) {
        List< Integer > listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7);
        List< Double > listOfDoubles = List.of(2.0, 1.5, 4.5, 2.5, 1.5);

        calculateSum(listOfIntegers);
        calculateSum(listOfDoubles);
    }
}
