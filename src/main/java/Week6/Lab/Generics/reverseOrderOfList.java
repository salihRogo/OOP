package Week6.Lab.Generics;

import java.util.ArrayList;
import java.util.List;

public class reverseOrderOfList {
    public static < T > List < T > reverseList(List< T > originalList) {
        List < T > reversedList = new ArrayList<>();

        for (int i = originalList.size() - 1; i >= 0; i--) {
            reversedList.add(originalList.get(i));
        }

        return reversedList;
    }

    public static void main(String[] args) {
        List < Integer > numbers = List.of(1, 2, 3, 4, 5, 6);
        List < String > colors = List.of("Red", "Green", "Orange");

        List < Integer > reversedNumbers = reverseList(numbers);
        List < String > reversedColors = reverseList(colors);

        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Reversed list of numbers: " + reversedNumbers);
        System.out.println();
        System.out.println("Original list of colors: " + colors);
        System.out.println("Reversed list of colors: " + reversedColors);
    }
}
