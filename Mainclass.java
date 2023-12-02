
package Codesofpr3;

import java.util.ArrayList;
import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Choose the type of employee:");
        System.out.println("1. Hourly Employee");
        System.out.println("2. Salaried Employee");
        System.out.println("3. Executive Employee");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                employees.add(createHourlyEmployee(sc));
                break;
            case 2:
                employees.add(createSalariedEmployee(sc));
                break;
            case 3:
                employees.add(createExecutiveEmployee(sc));
                break;
            default:
                System.out.println("Wrong operation selected");
        }

        displayEmployeeDetails(employees);
    }

    private static HourlyEmployee createHourlyEmployee(Scanner sc) {
        System.out.println("Enter details for Hourly Employee:");
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Employee Name: ");
        sc.nextLine();
        String empName = sc.nextLine();
        System.out.print("Designation: ");
        String designation = sc.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = sc.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = sc.nextInt();

        return new HourlyEmployee(empId, empName, designation, hourlyRate, hoursWorked);
    }

    private static SalariedEmployee createSalariedEmployee(Scanner scanner) {
        System.out.println("Enter details for Salaried Employee:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        System.out.print("Employee Name: ");
        scanner.nextLine(); // Consume newline character
        String empName = scanner.nextLine();
        System.out.print("Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();

        return new SalariedEmployee(empId, empName, designation, monthlySalary);
    }

    private static ExecutiveEmployee createExecutiveEmployee(Scanner s) {
        System.out.println("Enter details for Executive Employee:");
        System.out.print("Employee ID: ");
        int empId = s.nextInt();
        System.out.print("Employee Name: ");
        s.nextLine();
        String empName = s.nextLine();
        System.out.print("Designation: ");
        String designation = s.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = s.nextDouble();

        //This loop will only execute for Executive employee
        double bonusPercentage;
        do {
            System.out.print("Bonus Percentage for Executive Employee (0-100): ");
            bonusPercentage = s.nextDouble();
        } while (bonusPercentage < 0 || bonusPercentage > 100); // Validate bonus percentage

        return new ExecutiveEmployee(empId, empName, designation, monthlySalary, bonusPercentage);
    }

    private static void displayEmployeeDetails(ArrayList<Employee> employees) {
        double totalPayroll = 0.0;

        for (Employee employee : employees) {
            System.out.println("\n");
            System.out.println("Employee Details:");
            employee.displayDetails();
            double weeklySalary = 0.0;
            double bonus = 0.0;

            if (employee instanceof HourlyEmployee) {
                weeklySalary = ((HourlyEmployee) employee).calculateWeeklySalary();
                bonus = ((HourlyEmployee) employee).calculateBonus();
            } else if (employee instanceof SalariedEmployee) {
                weeklySalary = ((SalariedEmployee) employee).calculateWeeklySalary();
                bonus = ((SalariedEmployee) employee).calculateBonus();
            } else if (employee instanceof ExecutiveEmployee) {
                weeklySalary = ((ExecutiveEmployee) employee).calculateWeeklySalary();
                bonus = ((ExecutiveEmployee) employee).calculateBonus();
            }

            System.out.println("Weekly Salary: $" + weeklySalary);
            System.out.println("Annual Earnings: $" + employee.calculateAnnualEarnings());
            if (bonus > 0) {
                System.out.println("Bonus: $" + bonus);
            }
            System.out.println();

            totalPayroll += (weeklySalary * 4) + bonus; // Assuming 4 weeks in a month
        }

        System.out.println("Total Payroll: $" + totalPayroll);
    }
}
