package Code_for_Lab5;

public class BankA implements BankInterface{
    private double balance;

    BankA(double balance){
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0;
    }
}
