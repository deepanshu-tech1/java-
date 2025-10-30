import java.util.Scanner;
class leap{
	int year ;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the year");
	year = sc.nextInt();

	// check the year is leap or not

	public void checkleap(){
		if(year%4==0|| year %100==0){
			System.out.println("year is leap year"+ year);

		}

		else{
			System.out.println("your provided year is not leap year");

		}
	}
}

public class  LeapYear{
	public static void main(String[] args){
		 leap a = new leap();
		 a.checkleap();
	}
}