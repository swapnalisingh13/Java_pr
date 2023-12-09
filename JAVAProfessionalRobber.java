package Pract_Code_For_4;
class JAVAProfessionalRobber extends Robber {
    @Override
    void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    int RowHouses(int[] houses) {
        if (houses.length < 2) {
            System.out.println("At least two houses required.");
            return 0;
        }

        int highest_val = 0;
        int second_highest = 0;

        for (int house : houses) {
            int temp = highest_val;
            highest_val = Math.max(highest_val, second_highest + house);
            second_highest = temp;
        }

        return Math.max(highest_val, second_highest);
    }

    int RoundHouses(int[] houses) {
        if (houses.length < 3) {
            System.out.println("At least three houses required for the circular house scenario.");
            return 0;
        }

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }

        int maxProfit = dp[houses.length - 2];

        dp[0] = 0;
        dp[1] = houses[1];

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }

        return Math.max(maxProfit, dp[houses.length - 1]);
    }

    int SquareHouse(int[] houses) {
        if (houses.length != 4) {
            System.out.println("SquareHouse requires an array of exactly 4 values.");
            return 0;
        }

        return Math.max(houses[0] + houses[2], houses[1] + houses[3]);
    }

    int MultiHouseBuilding(int[][] houses) {
        if (houses.length == 0 || houses[0].length == 0) {
            System.out.println("No houses to rob.");
            return 0;
        }

        int rows = houses.length;
        int cols = houses[0].length;

        if (cols == 1) {
            int maxProfit = 0;
            for (int i = 0; i < rows; i++) {
                maxProfit += houses[i][0];
            }
            return maxProfit;
        }

        int[][] dp = new int[rows][cols];


        for (int i = 0; i < cols; i++) {
            dp[0][i] = houses[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxVal = 0;
                for (int k = 0; k < cols; k++) {
                    if (k != j) {
                        maxVal = Math.max(maxVal, dp[i - 1][k]);
                    }
                }
                dp[i][j] = houses[i][j] + maxVal;
            }
        }

        int maxProfit = 0;
        for (int j = 0; j < cols; j++) {
            maxProfit = Math.max(maxProfit, dp[rows - 1][j]);
        }

        return maxProfit;
    }

}

