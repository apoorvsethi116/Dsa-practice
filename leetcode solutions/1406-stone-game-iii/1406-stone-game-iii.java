class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
       
        int[] dp = new int[4]; 
        

        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            int maxAdvantage = Integer.MIN_VALUE;
            
            
            for (int k = 0; k < 3 && i + k < n; k++) {
                take += stoneValue[i + k];
                int opponentAdvantage = dp[(i + k + 1) % 4];
                maxAdvantage = Math.max(maxAdvantage, take - opponentAdvantage);
            }
            
            dp[i % 4] = maxAdvantage;
        }
        
        
        int aliceAdvantage = dp[0];
        
        if (aliceAdvantage > 0) {
            return "Alice";
        } else if (aliceAdvantage < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}