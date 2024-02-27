package MidtermExam1stMakeupSalkan;

import java.util.ArrayList;
import java.util.List;

interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {

}

class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape {
    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeManager {
    public List<Drawable> drawAll(List<Drawable> shapes) {
        List<Drawable> returnMe = new ArrayList<>();
        for (Drawable shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                circle.setRadius(15);
                returnMe.add(circle);
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                square.setSideLength(5);
                returnMe.add(square);
            }
        }
        return returnMe;
    }
}

class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Square s1 = new Square();
        Square s2 = new Square();

        List<Drawable> shapes = new ArrayList<>();
        shapes.add(c1);
        shapes.add(c2);
        shapes.add(s1);
        shapes.add(s2);

        ShapeManager shapeManager = new ShapeManager();
        List<Drawable> fixed = shapeManager.drawAll(shapes);

        for (Drawable shape : fixed) {
            shape.draw();
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println(circle.getRadius());
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println(square.getSideLength());
            }
        }
    }
}
