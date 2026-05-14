import java.util.Scanner;

public class Bully {

    static boolean[] active = new boolean[5];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initially all processes are active
        for (int i = 0; i < 5; i++) {
            active[i] = true;
        }

        System.out.println("Processes: P1 P2 P3 P4 P5");
        System.out.println("P5 is initial coordinator");

        while (true) {
            System.out.println("\n1. Bring UP process");
            System.out.println("2. Bring DOWN process");
            System.out.println("3. Send message");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter process to UP: ");
                    int up = sc.nextInt();
                    active[up - 1] = true;
                    System.out.println("Process " + up + " is UP");
                    break;

                case 2:
                    System.out.print("Enter process to DOWN: ");
                    int down = sc.nextInt();
                    active[down - 1] = false;
                    System.out.println("Process " + down + " is DOWN");
                    break;

                case 3:
                    System.out.print("Enter sender process: ");
                    int sender = sc.nextInt();

                    if (!active[sender - 1]) {
                        System.out.println("Process is DOWN");
                        break;
                    }

                    System.out.println("Process " + sender + " starts election");

                    int coordinator = -1;

                    // Send election message to higher processes
                    for (int i = sender; i < 5; i++) {
                        if (active[i]) {
                            System.out.println("Election message sent to P" + (i + 1));
                            coordinator = i + 1;
                        }
                    }

                    if (coordinator == -1) {
                        System.out.println("No higher active process found");
                        coordinator = sender;
                    }

                    System.out.println("New Coordinator is P" + coordinator);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
