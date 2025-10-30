import java.util.Scanner;
class Operations{
	// instance of variable 
	int a , b;

	Scanner sc = new Scanner(System.in);
	a = sc.nextInt();
	a = sc.nextInt();
	public void add(){
	long sum = a+b;
	System.out.println("add of two number is "+ sum);
		}

		//perform substract opertions 
		public void substract(){
		int sub = a-b;
		System.out.println("the substract of two number is "+ sub);
		}

// perform multiplication operations 
public void multiplications(){
long mul = a*b;
System.out.println("the multiplications of two number is "+ mul);

	
}

// perform division operations 
public void division(){
	float div = a/b;
	System.out.println("the division of two number is " + div);
}

sc.close();


}

// main class 
public class Arithmatic{
	public static void main(String[] args){
	Operations a = new Operations();
	a.add();
	a.substract();

	a.multiplication();
	a.divisions();
	}
}