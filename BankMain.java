package Code_for_Lab5;

public class BankMain {
    public static void main(String args[]){
        System.out.println("Welcome to Banking manager! The interest and balances are given below");
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        System.out.println("Bank A:");
        System.out.println("Balance: " + bankA.getBalance());
        System.out.println("Interest Rate: " + (bankA.getInterestRate()) + "%");

        System.out.println("\nBank B:");
        System.out.println("Balance: " + bankB.getBalance());
        System.out.println("Interest Rate: " + (bankB.getInterestRate()) + "%");

        System.out.println("\nBank C:");
        System.out.println("Balance: " + bankC.getBalance());
        System.out.println("Interest Rate: " + (bankC.getInterestRate()) + "%");

    }
}
