package college;

import java.util.Scanner;

/*----------------------------------------------
   Parent class: Shape
   Purpose: Base class that defines a general area() method.
-----------------------------------------------*/
class Shape {
    // Method to be overridden by child classes
    void area() {
        System.out.println("Area of shape cannot be determined");
    }
}

/*----------------------------------------------
   Child class: Circle
   Purpose: Overrides area() method to calculate
            the area of a circle.
-----------------------------------------------*/
class Circle extends Shape {
    double radius;

    // Constructor to initialize radius
    Circle(double r) {
        radius = r;
    }

    // Overriding area() method
    @Override
    void area() {
        double a = Math.PI * radius * radius;
        System.out.println("Area of Circle = " + a);
      System.out.println(".............................................................");
    }
}

/*----------------------------------------------
   Child class: Square
   Purpose: Overrides area() method to calculate
            the area of a square.
-----------------------------------------------*/
class Square extends Shape {
    int side;

    // Constructor to initialize side
    Square(int s) {
        side = s;
    }

    // Overriding area() method
    @Override
    void area() {
        int a = side * side;
        System.out.println("Area of Square = " + a);
            System.out.println(".............................................................");

    }
}

/*----------------------------------------------
   Main class: AreaMain
   Purpose: Demonstrates method overriding
-----------------------------------------------*/
public class Overriding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== AREA FINDER (Using Method Overriding) ===");
            System.out.println("1. Area of Circle");
            System.out.println("2. Area of Square");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            Shape shape; // Parent class reference

            switch (choice) {
                case 1:
                    System.out.print("Enter radius of circle: ");
                    double radius = sc.nextDouble();
                    shape = new Circle(radius); // Upcasting
                    shape.area(); // Calls Circle's overridden method
                    break;

                case 2:
                    System.out.print("Enter side of square: ");
                    int side = sc.nextInt();
                    shape = new Square(side); // Upcasting
                    shape.area(); // Calls Square's overridden method
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
