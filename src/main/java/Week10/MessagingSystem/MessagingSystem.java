package Week10.MessagingSystem;

public class MessagingSystem {
    @CanSendMessage
    @RequiresPermission(1)
    public void sendMessage(User user){
        System.out.println(user.username() + " is restricted!");
    }

    @CanSendMessage
    @RequiresPermission(2)
    public void sendMessage (Admin admin, String message){
        System.out.println(admin.getUsername() + " sent a message: " + message);
    }

}
