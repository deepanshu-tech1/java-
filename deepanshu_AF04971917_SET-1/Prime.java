//Write a program to print all prime numbers between 1 and 100 using loops.

class primenumber{
	// check prime number 
	public  int checkprime(){
		System.out.println("Prime numbers between 1 and 100 are:");

        // create  a for loop for find the prime number from 1 to 100
        for (int num = 2; num <= 100; num++) {
            boolean isPrime = true;

            // Check if num is divisible by any number from 2 to num/2
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false; // Not a prime number
                    break;
                }
            }

            // If isPrime is still true, print the number
            if (isPrime) {
                System.out.print( "...." +"prime number is"+num + " ");
            }
        }

	}

}


public class Prime {
    public static void main(String[] args) {
    	// create object of class 
    	primenumber  p = new primenumber();
    	// call the method of prime number 
    	p.checkprime();


        
    }
}
