import java.util.*;

class Process {
    int id;
    boolean active = true;
}

public class RingElection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            System.out.print("Enter process ID: ");
            p[i].id = sc.nextInt();
        }

        // Assume last process failed
        p[n - 1].active = false;
        System.out.println("Process " + p[n - 1].id + " failed.");

        System.out.print("Enter initiator index: ");
        int init = sc.nextInt();

        int current = init;
        int max = -1;

        System.out.println("Election in progress...");

        do {
            if (p[current].active) {
                System.out.println("Process " + p[current].id + " participates");
                max = Math.max(max, p[current].id);
            }
            current = (current + 1) % n;

        } while (current != init);

        System.out.println("New Coordinator: " + max);
    }
}
