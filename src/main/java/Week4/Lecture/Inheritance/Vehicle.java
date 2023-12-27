package Week4.Lecture.Inheritance;

enum Color {
    BLACK, GRAY, WHITE
}

enum FuelType {
    DIESEL, PETROL
}

class Vehicle {
    private int numOfGears;
    private int numOfWheels;
    private Color color;

    public Vehicle(int numOfGears, int numOfWheels, Color color) {
        this.numOfGears = numOfGears;
        this.numOfWheels = numOfWheels;
        this.color = color;
    }

    public Vehicle() {
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}


class Car extends Vehicle {
    private FuelType fuelType;

    public Car(int numOfGears, int numOfWheels, Color color, FuelType fuelType) {
        super(numOfGears, numOfWheels, color);
        this.fuelType = fuelType;
    }

    public Car(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}


class Bicycle extends Vehicle {

    private boolean doesItHaveDinama;

    public Bicycle(int numOfGears, int numOfWheels, Color color, boolean isDoesItHaveDinama) {
        super(numOfGears, numOfWheels, color);
        this.doesItHaveDinama = isDoesItHaveDinama;
    }

    public boolean getDoesItHaveDinama() {
        return doesItHaveDinama;
    }

    public void setDoesItHaveDinama(boolean doesItHaveDinama) {

        this.doesItHaveDinama = doesItHaveDinama;
    }

}