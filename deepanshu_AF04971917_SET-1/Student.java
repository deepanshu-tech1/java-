//Create a class Student with fields name, rollNo, and marks. Include methods
 //inputData() and displayData().
import java.util.Scanner;
class studentdata{
	// instance of variable 
	String name,int roll,float marks;
	Scanner sc = new Scanner(System.in);
 public void inputdata(){
 		System.out.println("enter your name");
 		name = sc.nextLine();
 		System.out.println("enter your roll no");
 		roll = sc.nextInt();
 		System.out.println("enter your marks");
 		marks = sc.nextFloat();
 		System.out.println("..........................");

 }
 // display the data 
 public void displaydata(){
 	System.out.println("your enter name is ......"+ name);
 	System.out.println("your enter roll no is ....."+ roll);
 	System.out.println("your enter marks is....."+ marks);
 	System.out.println(".................................");

 }

}

public class Student{
	public static void main(String[] args){
		studentdata a = new studentdata();
		System.out.println("enter your data");
		a.inputdata();
		System.out.println("............................");
		system.out.println("your entered data is..... ");
		a.displaydata();
	}
}