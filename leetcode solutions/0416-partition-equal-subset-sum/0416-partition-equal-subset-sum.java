class Solution {
    public boolean canPartition(int[] nums) {
        

        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length+1][target+1];
        //if target == 0 , yeas achievable

        for(int x = 0; x<dp.length; x++){
            dp[x][0] = true;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int v = nums[i-1];

                if(v <= j && dp[i-1][j - v]){
                    dp[i][j] = true;
                }else if(dp[i-1][j]){
                    //invalid exclude
                    dp[i][j] = true;
                }
            }
        }

        return dp[nums.length][target];
    }
}