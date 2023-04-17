/*
Write a java program to define a class student with data members like name, rollno, age, gender, sub1, and sub2. Defines appropriate methods to initialize and displays the values of data members also calculates total marks, percentage and grade by the ‘n’ number of students.
Note: get the values at run time with corresponding objects. Write the sample output with all the
operations.

*/

import java.util.Scanner;

class Student {
    String name, gender;
    int rollNo, age, sub1, sub2;
    
    // Method to initialize student data members
    void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter roll number: ");
        rollNo = sc.nextInt();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        System.out.print("Enter gender: ");
        gender = sc.next();
        System.out.print("Enter marks for subject 1: ");
        sub1 = sc.nextInt();
        System.out.print("Enter marks for subject 2: ");
        sub2 = sc.nextInt();
    }
    
    // Method to display student details
    void display() {
        System.out.println("\nStudent details:");
        System.out.println("Name: " + name);
        System.out.println("Roll number: " + rollNo);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Marks for subject 1: " + sub1);
        System.out.println("Marks for subject 2: " + sub2);
    }
    
    // Method to calculate total marks
    int calculateTotalMarks() {
        return sub1 + sub2;
    }
    
    // Method to calculate percentage
    double calculatePercentage() {
        return (double) calculateTotalMarks() / 2;
    }
    
    // Method to calculate grade based on percentage
    String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C+";
        } else if (percentage >= 40) {
            return "C";
        } else {
            return "F";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        Student[ ] students = new Student[n];
        
        // Initialize student data members for each student object
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i+1) + ":");
            students[i] = new Student();
            students[i].initialize();
        }
        
        // Display student details for each student object
        for (int i = 0; i < n; i++) {
            students[i].display();
            int totalMarks = students[i].calculateTotalMarks();
            double percentage = students[i].calculatePercentage();
            String grade = students[i].calculateGrade();
            System.out.println("Total marks: " + totalMarks);
            System.out.println("Percentage: " + percentage);
            System.out.println("Grade: " + grade);
        }
    }
}
