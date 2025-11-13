public class berkeley {

	    public static void main(String[] args) {

	        int[] systemClocks = { 10, 12, 13, 11, 14 };

	        int sum = 0;
	        for (int c : systemClocks) sum += c;

	        int avg = sum / systemClocks.length;

	        System.out.print("Updated system clocks: ");
	        for (int c : systemClocks) {
	            int adjusted = avg + (avg - c);
	            System.out.print(adjusted + " ");
	        }

	        System.out.println("\nMaster clock: " + avg);
	    }
	}
