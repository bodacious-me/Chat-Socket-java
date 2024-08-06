import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void NewClient(){
        try {

            
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Connected To Server");


            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            Thread sendThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String message = scanner.nextLine();
                    out.println(message);
                }
            });
            sendThread.start();

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Recieved Message: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
