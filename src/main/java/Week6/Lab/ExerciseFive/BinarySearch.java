package Week6.Lab.ExerciseFive;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Arrays.*;

class BinarySearch {
    // Returns index of x if it is present in arr[].

    public static boolean search(int[] arr, int x) {
        // int arr[] = { -3, 2, 3, 4, 7, 18, 12 };
        Arrays.sort(arr);
        // int arr[] = { -3, 2, 3, 4, 7, 12, 18 }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[middle] == x)
                return true;

            // If x greater, ignore left half
            if (arr[middle] < x)
                left = middle + 1;

                // If x is smaller, ignore right half
            else
                right = middle - 1;
        }

        // If we reach here, then element was not present
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        // Here you can test your binary search
        int[] array = { -3, 2, 3, 4, 7, 18, 12 };
        Scanner reader = new Scanner(System.in);

        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();

        System.out.print("Enter your searched number: ");
        String searchedValue = reader.nextLine();
        System.out.println();

        boolean result = BinarySearch.search(array, Integer.parseInt(searchedValue));
        System.out.println((result) ? ("Value " + searchedValue + " is in the array") : ("Value " + searchedValue + " is not in the array"));
    }
}
