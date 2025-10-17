
import java.util.Scanner;

class Fact {
    // Recursive method to calculate factorial
    long fact(int a) {
        if (a == 0 || a == 1) {
            return 1;
        } else {
            return a * fact(a - 1); // Correct recursive call
        }
    }
}


public class factorial {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter any number => ");
	        int n = sc.nextInt();

	        Fact f = new Fact(); // Create object
	        long result = f.fact(n);       // Call the fact() method

	        System.out.println("Factorial of " + n + " is: " + result);
	    }
  

}



