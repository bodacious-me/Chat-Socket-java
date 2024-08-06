import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {
    private static final int PORT = 8080;
    private static HashSet<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Chat server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                clients.add(out);

                Thread t = new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received message: " + message);
                            for (PrintWriter client : clients) {
                                client.println(message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                t.start();
            }
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
}