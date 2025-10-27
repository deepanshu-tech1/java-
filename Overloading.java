package college; // Package declaration (optional)

// Import Scanner class for user input
import java.util.Scanner;

/*----------------------------------------------
   Class: AreaCalculator
   Purpose: Contains overloaded methods to calculate
            area of different shapes.
-----------------------------------------------*/
class AreaCalculator {
    
    // Method to calculate area of a circle
    // Formula: π * r * r
    public double area(double radius) {
        return Math.PI * radius * radius;
    }
    
    // Overloaded method to calculate area of a square
    // Formula: side * side
    public int area(int side) {
        return side * side;
    }
}

/*----------------------------------------------
   Class: AreaMain
   Purpose: Contains main() method
            Displays menu and calls methods from AreaCalculator
-----------------------------------------------*/
public class Overloading {
    public static void main(String[] args) {
        
        // Creating Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Creating object of AreaCalculator class
        AreaCalculator calc = new AreaCalculator();
        
        int choice; // Variable to store user choice
        
        // do-while loop to show menu repeatedly
        do {
            System.out.println("\n=== AREA CALCULATOR ===");
            System.out.println("1. Area of Circle");
            System.out.println("2. Area of Square");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt(); // Taking user choice
            
            // Using switch-case for menu selection
            switch (choice) {
                
                case 1:
                    // Input radius and calculate circle area
                    System.out.print("Enter radius of circle: ");
                    double radius = sc.nextDouble();
                    System.out.println("Area of Circle = " + calc.area(radius));
                    System.out.println(".........................................");

                    break;
                    
                case 2:
                    // Input side and calculate square area
                    System.out.print("Enter side of square: ");
                    int side = sc.nextInt();
                    System.out.println("Area of Square = " + calc.area(side));
                    System.out.println(".........................................");
                   
                    break;
                    
                case 3:
                    // Exit message
                    System.out.println("Exiting program...");
                    System.out.println(".........................................");

                    break;
                    
                default:
                    // Invalid input handling
                    System.out.println("Invalid choice! Try again.");
                    System.out.println(".........................................");

            }
        } while (choice != 3); // Repeat until user chooses to exit
        
        // Close scanner to prevent resource leak
        sc.close();
    }
}
