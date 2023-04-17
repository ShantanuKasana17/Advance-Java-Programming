//*

Write a java program to check whether number is palindrome or not using while, if and else statements.





*//
  
  import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        int num, reversedNum = 0, remainder, originalNum;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();

        originalNum = num;

        while (num != 0) {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num /= 10;
        }

        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is a palindrome.");
        } else {
            System.out.println(originalNum + " is not a palindrome.");
        }
    }
}
