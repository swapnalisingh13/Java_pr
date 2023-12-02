package Codesofpr3;

public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.07; // 7% bonus for Salaried Employee
    }

    @Override
    public double calculateAnnualEarnings() {
        return monthlySalary * 12; // Assuming 12 months in a year
    }

    public double calculateWeeklySalary() {
        return monthlySalary / 4; // Assuming 4 weeks in a month
    }
}
