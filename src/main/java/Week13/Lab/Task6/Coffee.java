package Week13.Lab.Task6;

import java.util.ArrayList;

interface CoffeeBuilder {
    CoffeeBuilder buildType();
    CoffeeBuilder buildSize();
    CoffeeBuilder buildToppings();

    Coffee build();

    int getSize();
    String getType();
    ArrayList<String> getToppings();

}

class Coffee {
    private String type;
    private int size;
    private ArrayList<String> toppings = new ArrayList<>();

    public Coffee(CoffeeBuilder coffeeBuilder) {
        this.size = coffeeBuilder.getSize();
        this.toppings = coffeeBuilder.getToppings();
        this.type = coffeeBuilder.getType();
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public static class EspressoBuilder implements CoffeeBuilder {
        private String type;
        private int size;
        private ArrayList<String> toppings = new ArrayList<>();

        public String getType() {
            return type;
        }

        public int getSize() {
            return size;
        }

        public ArrayList<String> getToppings() {
            return toppings;
        }

        public CoffeeBuilder buildType() {
            this.type = "Espresso";
            return this;
        }
        public CoffeeBuilder buildSize() {
            this.size = 1;
            return this;
        }
        public CoffeeBuilder buildToppings() {
            ArrayList<String> toppings = new ArrayList<>();
            toppings.add("cream");
            this.toppings = toppings;
            return this;
        }
        public Coffee build() {
            return new Coffee(this);
        }
    }
    public static class LatteBuilder implements CoffeeBuilder {
        private String type;
        private int size;
        private ArrayList<String> toppings = new ArrayList<>();

        @Override
        public String getType() {
            return type;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public ArrayList<String> getToppings() {
            return toppings;
        }

        public CoffeeBuilder buildType() {
            this.type = "Latte";
            return this;
        }
        public CoffeeBuilder buildSize() {
            this.size = 2;
            return this;
        }
        public CoffeeBuilder buildToppings() {
            ArrayList<String> toppings = new ArrayList<>();
            toppings.add("chocolate");
            toppings.add("whipped cream");
            this.toppings = toppings;
            return this;
        }
        public Coffee build() {
            return new Coffee(this);
        }
    }
    public static class CappuccinoBuilder implements CoffeeBuilder {
        private String type;
        private int size;
        private ArrayList<String> toppings = new ArrayList<>();

        @Override
        public String getType() {
            return type;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public ArrayList<String> getToppings() {
            return toppings;
        }

        public CoffeeBuilder buildType() {
            this.type = "Cappuccino";
            return this;
        }
        public CoffeeBuilder buildSize() {
            this.size = 3;
            return this;
        }
        public CoffeeBuilder buildToppings() {
            ArrayList<String> toppings = new ArrayList<>();
            toppings.add("coconut");
            toppings.add("kobasice");
            this.toppings = toppings;
            return this;
        }
        public Coffee build() {
            return new Coffee(this);
        }
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder) {
//        builder.buildSize();
//        builder.buildToppings();
//        builder.buildType();

        return builder.buildType().buildToppings().buildSize().build();
    }
}

class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();
        CoffeeBuilder builder = new Coffee.CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(builder);

        System.out.println(cappuccino.getType() + "---" + cappuccino.getSize());
    }
}