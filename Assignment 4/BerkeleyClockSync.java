import java.util.ArrayList;

public class BerkeleyClockSync {

    public static void main(String[] args) {

        // Initial clock times of systems
        int[] systemClocks = {10, 12, 13, 11, 14};

        int masterClock = 0;

        // Print initial clocks
        System.out.print("System clocks: ");
        for (int clock : systemClocks) {
            System.out.print(clock + " ");
        }
        System.out.println();

        // Step 1: Calculate average time
        int sum = 0;
        for (int clock : systemClocks) {
            sum += clock;
        }

        int averageClock = sum / systemClocks.length;

        // Step 2: Calculate differences
        ArrayList<Integer> differences = new ArrayList<>();
        for (int clock : systemClocks) {
            differences.add(averageClock - clock);
        }

        // Step 3: Calculate adjustment
        int adjustment = 0;
        for (int diff : differences) {
            adjustment += diff;
        }
        adjustment = adjustment / differences.size();

        // Step 4: Update master clock
        masterClock = averageClock - adjustment;

        // Step 5: Print updated clocks
        System.out.print("Updated system clocks: ");
        for (int clock : systemClocks) {
            System.out.print((clock - adjustment) + " ");
        }
        System.out.println();

        System.out.println("Master clock: " + masterClock);
    }
}
