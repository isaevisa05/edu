import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Thread serverThread = new Thread(new Server());
        serverThread.start();
    }

}
