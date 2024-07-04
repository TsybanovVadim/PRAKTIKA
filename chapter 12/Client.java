import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
    private final String name;
    private final BlockingQueue<Client> queue;

    public String getName() {
        return this.name;
    }
    public Client(String name, BlockingQueue<Client> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                queue.put(this);
                System.out.println(name + " ждет в очереди");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}