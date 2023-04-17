//*

Write a java program for employee details using class and Encapsulation to get empid, name, salary, PF and HRA. 
Find total salary for ‘n’ employees. Get the values at run time with corresponding objects.
Write the sample output with all the operations.




*//
  
  import java.util.Scanner;

class Employee {
    private int empid;
    private String name;
    private double salary;
    private double pf;
    private double hra;

    public Employee(int empid, String name, double salary, double pf, double hra) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.pf = pf;
        this.hra = hra;
    }

    public int getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPf() {
        return pf;
    }

    public double getHra() {
        return hra;
    }

    public double getTotalSalary() {
        return salary + pf + hra;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee #" + (i + 1) + ":");
            System.out.print("Enter employee ID: ");
            int empid = sc.nextInt();
            sc.nextLine(); // Consume newline character

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter employee PF: ");
            double pf = sc.nextDouble();

            System.out.print("Enter employee HRA: ");
            double hra = sc.nextDouble();

            employees[i] = new Employee(empid, name, salary, pf, hra);
        }

        System.out.println("\nEmployee details:");

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee #" + (i + 1) + ":");
            System.out.println("ID: " + employees[i].getEmpid());
            System.out.println("Name: " + employees[i].getName());
            System.out.println("Salary: " + employees[i].getSalary());
            System.out.println("PF: " + employees[i].getPf());
            System.out.println("HRA: " + employees[i].getHra());
            System.out.println("Total Salary: " + employees[i].getTotalSalary());
        }
    }
}
