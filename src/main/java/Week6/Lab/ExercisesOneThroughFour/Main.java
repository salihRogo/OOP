package Week6.Lab.ExercisesOneThroughFour;

import java.util.Arrays;

public class Main {
    public static int smallest(int[] array) {
        int smallestNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallestNum) {
                smallestNum = array[i];
            }
        }
        return smallestNum;
    }

    public static int indexOfTheSmallest(int[] array) {
        int smallestNum = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallestNum) {
                smallestNum = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int smallestNum = array[index];
        int smallestIndex = index;
        for (int i = index; i < array.length; i++) {
            if (array[i] < smallestNum) {
                smallestNum = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // First task
        int[] values1 = { 6, 5, 8, 7, 11 };
        System.out.println("Smallest: " + smallest(values1) + "\n");

        // Second task
        System.out.println("Index of the smallest: "  + indexOfTheSmallest(values1) + "\n");

        // Third task
        int[] values3 = { -1, 6, 9, 8, 12 };
        System.out.println(indexOfTheSmallestStartingFrom(values3, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values3, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values3, 4) + "\n");

        // Fourth task
        int[] values2 = { 3, 2, 5, 4, 8 };

        System.out.println(Arrays.toString(values2));
        swap(values2, 1, 0);
        System.out.println(Arrays.toString(values2));
        swap(values2, 0, 3);
        System.out.println(Arrays.toString(values2));

    }


}
