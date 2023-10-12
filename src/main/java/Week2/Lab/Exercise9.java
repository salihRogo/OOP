package Week2.Lab;

public class Exercise9 {
    public static void drawNumbersPiramid(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void drawNumbersPiramid2(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawNumbersPiramid(5);
        drawNumbersPiramid(10);
        drawNumbersPiramid2(10);
    }
}
