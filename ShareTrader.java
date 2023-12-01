import java.util.Scanner;

public class ShareTrader {
    static int maxProfit = 0;

    public static void findMaxProfit(int[] stockPrices) {
        for (int i = 0; i < stockPrices.length - 1; i += 2) {
            int profit = stockPrices[i + 1] - stockPrices[i];
            maxProfit += profit;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int n = s.nextInt();

        if (n % 2 != 0) {
            System.out.println("Please enter a valid number of stock prices (multiple of 2).");
            return;
        }
        int a = 0;
        int[] stockPrices = new int[n];
        System.out.println("Enter the stock prices below: ");
        for (int i = 0; i < n; i++) {
            a = i+1;
            System.out.println("Enter the "+ a +" price");
            stockPrices[i] = s.nextInt();
        }

        findMaxProfit(stockPrices);

        System.out.println("\n Total profit: " + maxProfit);
    }
}
