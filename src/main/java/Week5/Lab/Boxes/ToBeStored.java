package Week5.Lab.Boxes;

import java.util.ArrayList;

interface ToBeStored{
    double weight();
}

class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String name, double weight) {
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.writer + ": " + this.name;
    }
}

class CD implements ToBeStored {
    private String artist;
    private String title;
    private int publishingYear;
    private double weight;

    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.title = title;
        this.publishingYear = publishingYear;
        this.weight = 0.1;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
    }
}

class Thing implements ToBeStored{
    private double weight;
    public double weight() {
        return this.weight;
    }
}

class Box  {
    private ArrayList<ToBeStored> things;
    private double maxWeight;
    public Box (double maxWeight){
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    public void add(ToBeStored thing){
        if (this.maxWeight > thing.weight()){
            this.things.add(thing);
        }
    }

    public double totalWeight() {
        double total = 0;
        for (ToBeStored thing : this.things){
            total += thing.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box: " + this.things.size() + " things, total weight " + this.totalWeight() + " kg";
    }

}


class Main {
    public static void main(String[] args) {
        Box box = new Box(10);
        box.add ( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box.add ( new Book("Robert Martin", "Clean Code", 1) );
        box.add ( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box.add ( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box.add ( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box.add ( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println(box);

    }
}