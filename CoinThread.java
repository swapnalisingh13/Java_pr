package NumberAdd_Pr_6_A_2348565;

import java.util.List;

class CoinThread extends Thread {
    private int[] coins;
    private int target;
    private List<Integer> result;

    public CoinThread(int[] coins, int target, List<Integer> result) {
        this.coins = coins;
        this.target = target;
        this.result = result;
    }

    @Override
    public void run() {
        //to store the no of possible ways
        int[] store = new int[target + 1];
        store[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                store[i] += store[i - coin];
            }
        }

        synchronized (result) {
            result.add(store[target]);
        }
    }
}

