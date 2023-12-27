package Week4.Lecture.Inheritance;

public class Main {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle(21, 2, Color.BLACK, false);
        Car peugeot = new Car(5, 4, Color.BLACK, FuelType.PETROL);

        System.out.println(bike.getDoesItHaveDinama());
        peugeot.setColor(Color.GRAY);
        System.out.println(peugeot.getColor());
    }
}
