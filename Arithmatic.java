import java.util.Scanner;
 class operation{
	 float a,b;
//	 create a constructor of class
	 public operation() {
		 System.out.print("enter the first number");
		 Scanner sc = new Scanner(System.in);
		 a = sc.nextFloat();
		 System.out.print("enter the second number");
		 b= sc.nextFloat();
		 sc.close();
		 
	 }
	 
//	  create a function for additon 
	 public void add() {
		 float sum = a+b;
		 System.out.println("enter the addition of number"+sum);

	 }
	 
	 public void subtract() {
		 float subtract= a-b;
		 System.out.println("enter the first number"+subtract);

	 }
	 
	 public void mul() {
		 float mul = a*b;
		 System.out.println("enter the first number"+mul);

	 }
	 public void division(){
		 float div=a/b;
		 System.out.println("the division" +a+ "and "+b+ "is "+div);

	 }
 }

public class Arithmatic {
	public static void main(String[] args) {
		operation f = new operation();
		f.add();
		f.subtract();
		f.mul();
		f.division();
		
		
	}

}
