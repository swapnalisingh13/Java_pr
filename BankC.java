package Code_for_Lab5;

public class BankC implements BankInterface{
    private double balance;

    BankC(double balance){
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9;
    }
}
