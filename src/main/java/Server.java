import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server implements Runnable {

    private static List<ClientSession> sessions = new ArrayList<>();

    public static void disconnect(ClientSession clientSession) {
        sessions.remove(clientSession);
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(12345);
            while (!server.isClosed()) {
                ClientSession clientSession = new ClientSession(server.accept());
                Thread clientThread = new Thread(clientSession);
                clientThread.start();
                sessions.add(clientSession);
            }
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
            System.exit(0);
        }
    }

    public static void sendMessage(ClientSession clientSession, String msg) {
        System.out.println("player send message: " + msg);
        for(ClientSession session : sessions) {
            if(session.equals(clientSession)) continue;
            session.sendMessage(msg);
        }
    }
}
