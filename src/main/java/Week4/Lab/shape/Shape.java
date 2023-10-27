package Week4.Lab.shape;

enum FillType {
    FILLED, NOT_FILLED
}

class Shape {
    private String color;
    private FillType filled;

    public Shape(String color, FillType filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FillType getFilled() {
        return filled;
    }

    public void setFilled(FillType filled) {
        this.filled = filled;
    }

    public String displayInfo() {
        return "Color of shape is " + this.color + " and it is " + this.filled;
    }

    public double getArea() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;
    public Circle(String color, FillType filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public String displayInfo(){
        return "Color of circle is " + this.getColor() + ", it is " + this.getFilled() + " and it's radius is " + this.radius;
    }
    @Override
    public double getArea(){
        return this.radius * this.radius * 3.14;
    }

    public double calculateCircumference(double PI){
        return 2 * PI * this.radius;
    }

    public double calculateCircumference() {
        double PI = 3.14;
        double v = 2 * PI * this.radius;
        return v;
    }
}

class Rectangle extends Shape {
    private final double height;
    private final double width;

    public Rectangle(String color, FillType filled, double height, double width) {
        super(color, filled);
        this.height = height;
        this.width = width;
    }

    @Override
    public String displayInfo(){
        return "Color of rectangle is " + this.getColor() + ", it is "
                + this.getFilled() + " and it's width and height are: height -  " + this.height + "   width - " + this.width;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }
}
