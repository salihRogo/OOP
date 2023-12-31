package Week13.Lab.Task2FactoryMethod;

interface Payment {
    void processPayment();
}

interface PaymentFactory {
    static Payment createPayment() {
        return null;
    };
}

class CreditCardPayment implements Payment{
    public void processPayment() {
        System.out.println("Credit card payment successfully processed");
    }
}

class CreditCardPaymentFactory implements PaymentFactory{
    public static Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPayment implements Payment{
    public void processPayment() {
        System.out.println("PayPal payment successfully processed");
    }
}

class PayPalPaymentFactory implements PaymentFactory{
    public static Payment createPayment() {
        return new PayPalPayment();
    }
}

class Main {
    public static void main(String[] args) {
        Payment cardPayment = CreditCardPaymentFactory.createPayment();
        cardPayment.processPayment();

        Payment payPalPayment = PayPalPaymentFactory.createPayment();
        payPalPayment.processPayment();
    }
}
