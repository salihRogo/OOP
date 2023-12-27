package Week5.Lecture.abstraction;

class Dog extends Animal {
    public Dog() {
        super();
    }

    @Override
    public String makeSound() {
        return "awwww";
    }
}

class Lion extends Animal {
    public String makeSound() {
        return "Grrrr";
    }

    public String letMeSeeYouRun () {
        return "Fast lion running";
    }
}

interface Animalable {
    String run();
}

interface Becirable {
    String shout();
}

class Ant implements Animalable, Becirable{
    public String run () {
        return "Ant is running";
    }
    public String shout () {
        return "Djenerikkk";
    }
}

abstract class Animal {
    private String name;
    public abstract String makeSound();

    public Animal() {

    }

    public String sayMyName(){
        return "LOUD NAME IS ".concat(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StartProgram {
    public static void main(String[] args) {
        Dog rex = new Dog();
    }
}