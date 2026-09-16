class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int a : nums){
            sum += a;
        }

        if(sum %2 != 0){
            return false;
        }

        int target = sum /2;

        boolean[][] dp = new boolean[nums.length+1][target+1];

        //if target = 0 , then it is achiveable

        for(int i = 0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int last = nums[i-1];
                if(last<=j && dp[i-1][j-last]){
                    //valid
                    dp[i][j] = true;
                }else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

            return dp[nums.length][target];
        }
        
    }
