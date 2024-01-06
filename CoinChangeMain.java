package NumberAdd_Pr_6_A_2348565;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinChangeMain {

    public static int countWays(int totalsum, int[] coins) throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        CoinThread[] threads = new CoinThread[1];

        threads[0] = new CoinThread(coins, totalsum, result);
        threads[0].start();

        for (CoinThread thread : threads) {
            thread.join();
        }

        int totalWays = 0;
        synchronized (result) {
            for (int num : result) {
                totalWays += num;
            }
        }
        return totalWays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the inputs below- ");
        System.out.println("Enter the Totalsum: ");
        int totalsum = scanner.nextInt();

        System.out.print("Enter the number of coins: ");
        int numCoins = scanner.nextInt();
        int[] coins = new int[numCoins];
        System.out.println("Enter the coins:");
        for (int i = 0; i < numCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        scanner.close();

        try {
            int ways = countWays(totalsum, coins);
            System.out.println("Number of ways for totalsum " + totalsum + ": " + ways);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
