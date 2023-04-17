//*
Implement the calculator operation using Interface. 
Create an Interface named arithmetic has declared methods add, sub, mul, div and mod with their method signature as access modifier is public by default,
void return type and two int / float arguments as their parameters.
Write the sample output with all the above operations.


*//
  
  
  import java.util.Scanner;

interface Arithmetic {
    void add(int num1, int num2);
    void sub(int num1, int num2);
    void mul(int num1, int num2);
    void div(int num1, int num2);
    void mod(int num1, int num2);
}

class Calculator implements Arithmetic {
    public void add(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    public void sub(int num1, int num2) {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }

    public void mul(int num1, int num2) {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }

    public void div(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero!");
        } else {
            System.out.println(num1 + " / " + num2 + " = " + ((double) num1 / num2));
        }
    }

    public void mod(int num1, int num2) {
        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println("\nArithmetic operations on " + num1 + " and " + num2 + ":");

        calc.add(num1, num2);
        calc.sub(num1, num2);
        calc.mul(num1, num2);
        calc.div(num1, num2);
        calc.mod(num1, num2);
    }
}
