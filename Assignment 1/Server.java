import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started...");
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream())
            );

            String line = "";
            while (!line.equals("Over")) {
                line = in.readUTF();
                System.out.println("Client: " + line);
            }

            socket.close();
            in.close();
            server.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
