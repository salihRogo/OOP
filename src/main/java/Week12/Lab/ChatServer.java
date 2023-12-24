package Week12.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<ClientHandler> clients = new ArrayList<>();

    public void start(int portNumber) {
        try(ServerSocket server = new ServerSocket(portNumber)){
            System.out.println("Number: " + portNumber);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);

                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start(1111);
    }
    public void broadcastMessage(String message, ClientHandler sender){
        for(ClientHandler client : clients){
            if(client!=sender){
                client.sendMessage(sender.getUsername() + ": " + message);

            }
        }
    }
    private class ClientHandler implements Runnable{
        private Socket clientSocket;
        private ChatServer server;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket clientSocket, ChatServer server) {
            this.clientSocket = clientSocket;
            this.server = server;
            this.reader = reader;
            this.writer = writer;
            this.username = username;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                username = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public String getUsername(){
            return username;
        }
        public void sendMessage(String message){
            writer.println(message);
        }

        @Override
        public void run(){
            try {
                System.out.println(username + " has joined the chat.");
                server.broadcastMessage(username + " has joined the chat.", this);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    server.broadcastMessage(clientMessage, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                server.removeClient(this);
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println(clientHandler.getUsername() + " has left the chat.");
        broadcastMessage(clientHandler.getUsername() + " has left the chat.", null);
    }
}
