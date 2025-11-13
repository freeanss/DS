import java.util.*;

public class token {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int n = 5;

	        System.out.print("Enter sender: ");
	        int s = sc.nextInt();

	        System.out.print("Enter receiver: ");
	        int r = sc.nextInt();

	        System.out.println("Token passing:");

	        int token = s;
	        while (token != r) {
	            System.out.println("Token at node " + token);
	            token = (token + 1) % n;
	        }

	        System.out.println("Receiver " + r + " received token.");
	    }
	}
