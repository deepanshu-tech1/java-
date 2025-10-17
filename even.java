import java.util.Scanner;
class evennumber{
	void printeven(int n) {
		for(int i = 2;i<=n;i++) {
			int j = 1;
			if(i%2==0) {
				System.out.print("the"+j+"even number"+i);
				j=j+1;
			}
			System.out.println("");
			
		}
	}
}


public class even {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        evennumber e = new evennumber();
	        System.out.print("enter the range of number ");
	        int n = sc.nextInt();
	        e.printeven(n);
	 }

}
