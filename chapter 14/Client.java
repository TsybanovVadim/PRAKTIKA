import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private BufferedReader inputReader;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Подключен к серверу: " + host + ":" + port);

    }

    public void run() {
        new Thread(new MessageReceiver()).start();
        try {
            while (true) {
                System.out.print("Введите сообщение: ");
                String message = inputReader.readLine();
                writer.println(message);
            }
        } catch (IOException e) {
            System.out.println("Ошибка связи с сервером: " + e.getMessage());
        }
    }

    private class MessageReceiver implements Runnable {
        @Override
        public void run() {
            try {
                String response;
                while ((response = reader.readLine()) != null) {
                    System.out.println("Received message from server: " + response);
                }
            } catch (IOException e) {
                System.out.println("Error receiving message from server: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 1111);
        client.run();
    }
}