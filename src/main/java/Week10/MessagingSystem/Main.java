package Week10.MessagingSystem;

public class Main {
    public static void main(String[] args){
        MessagingSystem messagingSystem = new MessagingSystem();

        User regularUser = new User("John");
        messagingSystem.sendMessage(regularUser);

        Admin admin = new Admin("Admin1");
        messagingSystem.sendMessage(admin, "Important!");

    }
}