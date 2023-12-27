package Week6.Lecture.PrinterWrongWay;

class StringPrinter {
    private String name;

    public StringPrinter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private void printString() {
        System.out.println(this.name);
    }
}

class IntegerPrinter {
    private int number;

    public IntegerPrinter(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class DoublePrinter {
    private double num;

    public DoublePrinter(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}