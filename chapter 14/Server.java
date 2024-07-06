/*2. Чат. Клиент посылает через сервер сообщение, которое получают все клиенты. Список клиентов хранится на сервере в файле.*/
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList<>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Сервер начал работу " + port);
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент был подключен к серверу: " + clientSocket.getInetAddress());
            clients.add(clientSocket);
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Сообщение от клиента: " + message);
                    broadcastMessage(message, clientSocket);
                    writeClientAddressToFile(clientSocket.getInetAddress());
                }
            } catch (IOException e) {
                System.out.println("Ошибка обработки клиента: " + e.getMessage());
            }
        }
    }

    private void broadcastMessage(String message, Socket sender) throws IOException {
        for (Socket clientSocket : clients) {
            if (clientSocket != sender) {
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println(message);
            }
        }
    }

    private void writeClientAddressToFile(InetAddress address) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("clientslist", true))) {
            writer.println(address.getHostAddress());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(1111);
        server.start();
    }
}
