Write a java program for simple interest calculation using interface

**********************************************Question 11********************************************

// Define an interface for interest calculation
interface InterestCalculator {
    double calculateSimpleInterest(double principal, double rate, double time);
}

// Implement the InterestCalculator interface for a specific interest calculation
class SimpleInterestCalculator implements InterestCalculator {
    @Override
    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}

// Main class for running the program
public class SimpleInterest {
    public static void main(String[] args) {
        // Create an instance of the SimpleInterestCalculator
        InterestCalculator calculator = new SimpleInterestCalculator();

        // Calculate the simple interest for a loan with a principal of $10,000, a rate of 5%, and a time of 2 years
        double principal = 10000.0;
        double rate = 5.0;
        double time = 2.0;
        double simpleInterest = calculator.calculateSimpleInterest(principal, rate, time);

        // Print the result
        System.out.println("Principal: $" + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " years");
        System.out.println("Simple Interest: $" + simpleInterest);
    }
}
