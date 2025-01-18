import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSession implements Runnable {

    Socket socket;
    Scanner scanner;
    PrintStream printStream;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            scanner = new Scanner(inputStream);
            printStream = new PrintStream(outputStream);

            printStream.println("Привет, добро пожаловать в наш чат!");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Server.sendMessage(this, line);
            }
            socket.close();
            Server.disconnect(this);
        } catch (Exception e) {
            System.out.println("exception " + e.getMessage());
            System.exit(0);
        }
    }

    public void sendMessage(String msg) {
        printStream.println(msg);
    }

    @Override
    public String toString() {
        return socket.getRemoteSocketAddress().toString() + socket.getLocalAddress().toString() + socket.getPort() + socket.getLocalPort();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ClientSession session)) return false;
        if(session.toString().equals(toString())) return true;
        return false;
    }
}
