*************************exception handling***************************
Describe the Exception Handling operations with example.
Ans : 
Exception handling is a mechanism used in Java to handle runtime errors or exceptions. It allows a programmer to gracefully handle errors, prevent application crashes, and provide meaningful error messages to users.
There are five keywords used in exception handling: try, catch, finally, throw, and throws.
1.	try block: The try block contains a set of statements that may generate an exception. The code inside the try block is executed normally, and if an exception occurs, it is thrown.
2.	catch block: The catch block catches the exception thrown by the try block. It contains a set of statements that handle the exception. The catch block must have at least one parameter of type Exception or its subclass, which is used to receive the thrown exception.
3.	finally block: The finally block is executed after the try and catch blocks, regardless of whether an exception is thrown or not. It is used to release resources or perform other clean-up operations.
4.	throw keyword: The throw keyword is used to explicitly throw an exception. It is used to signal an error condition.
5.	throws keyword: The throws keyword is used to declare that a method may throw an exception. It is used in the method signature to specify the exception types that can be thrown.
Example:
import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter another number: ");
            int num2 = sc.nextInt();
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program completed.");
        }
    }
}
