package Week12.Lab;

public class ChatApplication {
    public static void main(String[] args) {
        // Run the server
        ChatServer chatServer = new ChatServer();
        chatServer.start(8080);
    }
}
