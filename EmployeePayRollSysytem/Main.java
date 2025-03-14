package oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
    	System.out.println();
        return "Employee: name=" + name + ", id=" + id + ", salary=" + calculateSalary();
    }
    

}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         PayrollSystem payrollSystem = new PayrollSystem();
         
         // Adding 10 employees (7 Full-Time, 3 Part-Time)
         payrollSystem.addEmployee(new FullTimeEmployee("John Doe", 101, 5000.0));
         payrollSystem.addEmployee(new FullTimeEmployee("Alice Brown", 102, 5500.0));
         payrollSystem.addEmployee(new FullTimeEmployee("Michael Smith", 103, 6000.0));
         payrollSystem.addEmployee(new FullTimeEmployee("Sarah Johnson", 104, 4800.0));
         payrollSystem.addEmployee(new FullTimeEmployee("David Wilson", 105, 5300.0));
         payrollSystem.addEmployee(new FullTimeEmployee("Emma Davis", 106, 5700.0));
         payrollSystem.addEmployee(new FullTimeEmployee("Robert Miller", 107, 6200.0));
         
         payrollSystem.addEmployee(new PartTimeEmployee("Liam Thomas", 108, 25, 20.0));
         payrollSystem.addEmployee(new PartTimeEmployee("Olivia Martinez", 109, 30, 18.5));
         payrollSystem.addEmployee(new PartTimeEmployee("Noah Taylor", 110, 20, 22.0));

         while (true) {
             System.out.println("\nPayroll Management System");
             System.out.println("1. Add Full-Time Employee");
             System.out.println("2. Add Part-Time Employee");
             System.out.println("3. Remove Employee");
             System.out.println("4. Display Employees");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");
             
             int choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline
             
             switch (choice) {
                 case 1:
                     System.out.print("Enter Full-Time Employee Name: ");
                     String ftName = scanner.nextLine();
                     System.out.print("Enter Employee ID: ");
                     int ftId = scanner.nextInt();
                     System.out.print("Enter Monthly Salary: ");
                     double salary = scanner.nextDouble();
                     payrollSystem.addEmployee(new FullTimeEmployee(ftName, ftId, salary));
                     System.out.println("Full-Time Employee Added Successfully!");
                     break;

                 case 2:
                     System.out.print("Enter Part-Time Employee Name: ");
                     String ptName = scanner.nextLine();
                     System.out.print("Enter Employee ID: ");
                     int ptId = scanner.nextInt();
                     System.out.print("Enter Hours Worked: ");
                     int hoursWorked = scanner.nextInt();
                     System.out.print("Enter Hourly Rate: ");
                     double hourlyRate = scanner.nextDouble();
                     payrollSystem.addEmployee(new PartTimeEmployee(ptName, ptId, hoursWorked, hourlyRate));
                     System.out.println("Part-Time Employee Added Successfully!");
                     break;

                 case 3:
                     System.out.print("Enter Employee ID to Remove: ");
                     int removeId = scanner.nextInt();
                     payrollSystem.removeEmployee(removeId);
                     System.out.println("Employee Removed Successfully!");
                     break;

                 case 4:
                     System.out.println("\nEmployee Details:");
                     payrollSystem.displayEmployees();
                     break;

                 case 5:
                     System.out.println("Exiting...");
                     scanner.close();
                     System.exit(0);
                     break;

                 default:
                     System.out.println("Invalid choice! Please try again.");
             }
         }
    }
}