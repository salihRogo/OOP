package Week5.Lab.BoxesThirdTask;

import java.util.ArrayList;
import java.util.Collection;

class Thing {
    private double weight;
    private final String name;

    public double weight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public Thing(String name, double weight) {
        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Thing) {
            Thing thing = (Thing) o;
            return this.name.equals(thing.name);
        }
        return false;
    }
}

abstract class Box {
    public abstract void add(Thing thing);

    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}

class MaxWeightBox extends Box {
    private ArrayList<Thing> things;
    private final int maxWeight;
    private int weightInBox;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.weightInBox = 0;
        this.things = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        if (this.maxWeight >= this.weightInBox + thing.weight()) {
            this.weightInBox += thing.weight();
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : things){
            if (t.equals(thing)) {
                return true;
            }
        }
        return false;
    }
}

class OneThingBox extends Box {
    private ArrayList<Thing> things;
    public OneThingBox(){
        this.things = new ArrayList<>();
    }

    public void add(Thing thing) {
        if (this.things.isEmpty()){
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : things){
            if (t.equals(thing)){
                return true;
            }
        }
        return false;
    }
}

class BlackHoleBox extends Box {
    private ArrayList<Thing> things = new ArrayList<>();
    public BlackHoleBox() {

    }

    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));
        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));

        OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));
        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));

        BlackHoleBox blackBox = new BlackHoleBox();
        blackBox.add(new Thing("Saludo", 5));
        blackBox.add(new Thing("Pirkka", 5));
        System.out.println(blackBox.isInTheBox(new Thing("Saludo")));
        System.out.println(blackBox.isInTheBox(new Thing("Pirkka")));

        // Upcasting: Creating objects and assigning them to variables of type Box
        Box box1 = new MaxWeightBox(10);
        Box box2 = new OneThingBox();
        Box box3 = new BlackHoleBox();

        // Adding things to the boxes
        Thing thing1 = new Thing("Thing1", 3.0);
        Thing thing2 = new Thing("Thing2", 2.5);
        Thing thing3 = new Thing("Thing3", 1.0);
        box1.add(thing1);
        box2.add(thing2);
        box3.add(thing3);

        // Downcasting cautiously using the instanceof operator
        if (box1 instanceof MaxWeightBox) {
            MaxWeightBox maxWeightBox1 = (MaxWeightBox) box1;
            System.out.println("Downcasted to MaxWeightBox: " + maxWeightBox1.isInTheBox(thing1));
        }

        if (box2 instanceof OneThingBox) {
            OneThingBox oneThingBox = (OneThingBox) box2;
            System.out.println("Downcasted to OneThingBox: " + oneThingBox.isInTheBox(thing2));
        }

        if (box3 instanceof BlackHoleBox) {
            BlackHoleBox blackHoleBox = (BlackHoleBox) box3;
            System.out.println("Downcasted to BlackHoleBox: " + blackHoleBox.isInTheBox(thing3));
        }

    }
}
