package Week12.Lab;

class ChatApplication {
    public static void main(String[] args) {
        ChatServer newChatServer = new ChatServer();
        newChatServer.start(1111);
    }
}
