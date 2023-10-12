package Week2.Lab;

public class Exercise7 {
    private static void printStars(int amount) {
        int i = 0;
        while (i < amount) {
            System.out.print('*');
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printStars(5);
        printStars(3);
        printStars(9);
    }
}
