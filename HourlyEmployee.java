package Codesofpr3;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        setHoursWorked(hoursWorked); // Validate and set hoursWorked
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    //Adding a validation to check if the user didn't enter a impossible number
    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0 && hoursWorked <= 168) { // Validate range
            this.hoursWorked = hoursWorked;
        } else {
            System.out.println("Invalid hours worked. Should be between 0 and 168.");
        }
    }

    @Override
    public double calculateBonus() {
        // 5% bonus for Hourly Employee
        return calculateWeeklySalary() * 0.05;
    }

    @Override
    public double calculateAnnualEarnings() {
        //52 weeks in a year
        return hourlyRate * hoursWorked * 52;
    }

    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }
}

