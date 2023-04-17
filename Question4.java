//*
Write a java program for area calculation (circle, square, rectangle, cone and triangle) using classes and methods with switch statements.


  
  *//
  
  
  import java.util.Scanner;

class AreaCalculator {
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateSquareArea(double side) {
        return side * side;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateConeArea(double radius, double height) {
        return Math.PI * radius * (radius + Math.sqrt(radius * radius + height * height));
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the shape (circle, square, rectangle, cone, triangle): ");
        String shape = sc.nextLine().toLowerCase();

        switch (shape) {
            case "circle":
                System.out.print("Enter the radius: ");
                double radius = sc.nextDouble();
                System.out.println("Area of circle: " + AreaCalculator.calculateCircleArea(radius));
                break;
            case "square":
                System.out.print("Enter the side length: ");
                double side = sc.nextDouble();
                System.out.println("Area of square: " + AreaCalculator.calculateSquareArea(side));
                break;
            case "rectangle":
                System.out.print("Enter the length: ");
                double length = sc.nextDouble();
                System.out.print("Enter the width: ");
                double width = sc.nextDouble();
                System.out.println("Area of rectangle: " + AreaCalculator.calculateRectangleArea(length, width));
                break;
            case "cone":
                System.out.print("Enter the radius: ");
                radius = sc.nextDouble();
                System.out.print("Enter the height: ");
                double height = sc.nextDouble();
                System.out.println("Area of cone: " + AreaCalculator.calculateConeArea(radius, height));
                break;
            case "triangle":
                System.out.print("Enter the base length: ");
                double base = sc.nextDouble();
                System.out.print("Enter the height: ");
                height = sc.nextDouble();
                System.out.println("Area of triangle: " + AreaCalculator.calculateTriangleArea(base, height));
                break;
            default:
                System.out.println("Invalid shape.");
        }
    }
}
