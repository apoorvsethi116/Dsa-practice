class Solution {
    public int pivotIndex(int[] nums) {
        int[] sumL = new int[nums.length];
        int[] sumR = new int[nums.length];

        sumL[0] = nums[0];
        sumR[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i<nums.length; i++){
            sumL[i] = sumL[i-1] + nums[i];
        }

        for(int i = nums.length-2; i>=0; i--){
            sumR[i] = sumR[i+1] + nums[i];
        }

        for(int i = 0; i<nums.length; i++){
            if(sumL[i]-nums[i] == sumR[i]-nums[i]){
                return i;
            }
        }

        return -1;
    }
}