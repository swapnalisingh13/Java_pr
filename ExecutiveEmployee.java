package Codesofpr3;

public class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateBonus() {
        return (bonusPercentage / 100) * (calculateAnnualEarnings() / 12);
    }
}


