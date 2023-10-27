package Week4.Lab.shape;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle("red", FillType.FILLED, 5);
        Rectangle r = new Rectangle("black", FillType.NOT_FILLED, 4, 10);

        System.out.println(c.displayInfo());
        System.out.println(c.getArea());
        System.out.println(r.displayInfo());
        System.out.println(r.getArea());
    }
}
