package Lesson4.Server.Core;

public class ChatServer {

    public void start (int port) {
        System.out.println("Server connected at port: " + port);
    }

    public void stop () {
        System.out.println("Server disconnected");
    }
}
