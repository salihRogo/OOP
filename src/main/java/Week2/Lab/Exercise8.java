package Week2.Lab;

public class Exercise8 {
    public static void drawStarsPiramid(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void invertedStarsPiramid(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawStarsPiramid(5);
        drawStarsPiramid(10);
        System.out.println();
        invertedStarsPiramid(10);
    }
}
