import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {
    public static void main(String[] args) {
        BlockingQueue<Client> queue = new LinkedBlockingQueue<>();


        Operator operator1 = new Operator("Оператор 1", queue);
        Operator operator2 = new Operator("Оператор 2", queue);

        Client client1 = new Client("Клиент 1", queue);
        Client client2 = new Client("Клиент 2", queue);
        Client client3 = new Client("Клиент 3", queue);
        Client client4 = new Client("Клиент 4", queue);
        Client client5 = new Client("Клиент 5", queue);


        new Thread(operator1).start();
        new Thread(operator2).start();
        new Thread(client1).start();
        new Thread(client2).start();
        new Thread(client3).start();
        new Thread(client4).start();
        new Thread(client5).start();
    }
}