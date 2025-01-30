import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {

    LinkedBlockingDeque<Order> linkedBlockingDeque = new LinkedBlockingDeque<>();

    class Order {
        String name;
        long time;

        public Order(String name, long time) {
            this.name = name;
            this.time = time;
        }
    }

    final long startTime;

    Pizzeria() {
        startTime = System.currentTimeMillis();
        new PizzeriaCar().start();
        new PizzeriaCar().start();
    }

    class PizzeriaCar extends Thread {

        @Override
        public void run() {
            while (System.currentTimeMillis() - startTime < 5000) {
                Order order = null;
                try {
                    order = linkedBlockingDeque.poll(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    break;
                }
                if(order != null) {
                    if(System.currentTimeMillis() + 500 - order.time <= 750) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {break;}
                        System.out.println(order.name + " is delivered");
                    } else {
                        System.out.println(order.name + " is NOT delivered");
                    }
                }

            }
        }
    }

    void order (String name) {
        try {
            linkedBlockingDeque.put(new Order(name, System.currentTimeMillis()));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
