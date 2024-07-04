import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Operator implements Runnable {
    private final BlockingQueue<Client> queue;
    private final String name;

    public Operator(String name, BlockingQueue<Client> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Client client = queue.take();
                System.out.println(name + " обслуживает " + client.getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(name + " закончил обслуживать " + client.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}