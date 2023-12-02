package Codesofpr3;

public class Employee {
    private int empID;
    private String empName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.empID = employeeId;
        this.empName = employeeName;
        this.designation = designation;
    }

    //Displaying the basic details
    public void displayDetails() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Designation: " + designation);
    }

    public double calculateBonus() {
        // Default bonus calculation if not entered
        return 0.0;
    }

    public double calculateAnnualEarnings() {
        // Default annual earnings if empty
        return 0.0;
    }
}


