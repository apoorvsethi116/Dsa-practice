class Solution {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int j = 0; j<nums.length; j++){
            cs += nums[j];
            
            ms = Math.max(cs , ms);
            if(cs <0){
                cs = 0;
            }
        }

        return ms;
    }
}