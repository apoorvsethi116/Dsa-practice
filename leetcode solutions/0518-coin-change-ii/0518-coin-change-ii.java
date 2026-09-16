class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int curr = coins[i-1];

                if(curr<=j){
                    dp[i][j] = dp[i][j-curr] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        return dp[coins.length][amount];
    }
}