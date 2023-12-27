package Week6.Lecture.RightWayPrinter;

class OurNewPrinter<T> {

}

class OurPrinter<T, K> {
    private T myCustomThing;
    private K myAnotherThing;

    public OurPrinter(T myCustomThing, K myAnotherThing) {
        this.myCustomThing = myCustomThing;
        this.myAnotherThing = myAnotherThing;
    }

    public T getMyCustomThing() {
        return myCustomThing;
    }

    public void setMyCustomThing(T myCustomThing) {
        this.myCustomThing = myCustomThing;
    }

    public void print() {
        System.out.println(this.myCustomThing );
    }

    public K getMyAnotherThing() {
        return myAnotherThing;
    }

    public void setMyAnotherThing(K myAnotherThing) {
        this.myAnotherThing = myAnotherThing;
    }
}

class Implementation {
    public static void main(String[] args) {
        //OurPrinter<Integer> integerOurPrinter = new OurPrinter<>(15);
        //integerOurPrinter.print();

        //OurPrinter<String> stringOurPrinter = new OurPrinter<>("Mirna");
        //stringOurPrinter.print();
    }
}