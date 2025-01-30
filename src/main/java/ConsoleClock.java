import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleClock extends Thread {

    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                return;
            }
        }
    }
}
