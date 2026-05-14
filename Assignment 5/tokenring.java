import java.util.*;

public class tokenring {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = scan.nextInt();

        int token = 0;   // initial token holder
        int choice;

        // Display ring
        System.out.print("Ring: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
        }
        System.out.println("0");

        do {
            System.out.print("\nEnter sender: ");
            int sender = scan.nextInt();

            System.out.print("Enter receiver: ");
            int receiver = scan.nextInt();

            System.out.print("Enter data: ");
            int data = scan.nextInt();

            // Token passing
            System.out.print("Token passing: ");
            int i = token;
            while (i != sender) {
                System.out.print(i + " -> ");
                i = (i + 1) % n;
            }
            System.out.println(sender);

            // Sending data
            System.out.println("Sender " + sender + " sending data: " + data);

            // Forwarding
            i = (sender + 1) % n;
            while (i != receiver) {
                System.out.println("Data " + data + " forwarded by " + i);
                i = (i + 1) % n;
            }

            // Receiver
            System.out.println("Receiver " + receiver + " received data: " + data);

            // Token moves to sender
            token = sender;

            System.out.print("\nDo you want to send again? (1=Yes / 0=No): ");
            choice = scan.nextInt();

        } while (choice == 1);

        scan.close();
    }
}
