class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        // dp[i][j] = minimum number of coins required
        // to make amount j using first i coins

        // Initialize with "infinity"
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = amount + 1;
            }
        }

        // 0 coins are required to make amount 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                int curr = coins[i - 1];

                if (curr <= j) {

                    // Take current coin
                    int take = dp[i][j - curr] + 1;

                    // Don't take current coin
                    int dontTake = dp[i - 1][j];

                    dp[i][j] = Math.min(take, dontTake);

                } else {

                    // Current coin is bigger than amount
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // If impossible, return -1
        if (dp[coins.length][amount] == amount + 1) {
            return -1;
        }

        return dp[coins.length][amount];
    }
}