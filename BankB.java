package Code_for_Lab5;

public class BankB implements BankInterface{
    private double balance;

    BankB(double balance){
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4;
    }
}