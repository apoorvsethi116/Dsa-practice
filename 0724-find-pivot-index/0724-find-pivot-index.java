class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int a: nums){
            total += a;
        }

        int sumL = 0;

        for(int i = 0; i<n; i++){
            int sumR = total - sumL - nums[i];

            if(sumL == sumR){
                return i;
            }

            sumL += nums[i];
        }


        return -1;
    }
}