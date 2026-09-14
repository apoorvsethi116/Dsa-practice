class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for(int i = 1; i<n; i++){
            int tempMax = Math.max(
                nums[i],
                Math.max(nums[i]*max , nums[i]*min)
            );

            int tempMin = Math.min(
                nums[i],
                Math.min(nums[i]*max , nums[i]*min)
            );

            max = tempMax;
            min = tempMin;

            ans = Math.max(ans , max);
        }


        return ans;
    }
}