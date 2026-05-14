import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );

            DataOutputStream out = new DataOutputStream(
                socket.getOutputStream()
            );

            String line = "";
            while (!line.equals("Over")) {
                line = br.readLine();
                out.writeUTF(line);
            }

            out.close();
            br.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
