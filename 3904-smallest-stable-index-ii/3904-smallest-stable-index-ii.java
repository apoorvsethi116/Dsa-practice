class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Precompute suffix minimums
        // suffMin[i] stores min(nums[i..n-1])
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }
        
        // Step 2: Traverse from left to right keeping track of prefix maximums
        int prefMax = nums[0];
        for (int i = 0; i < n; i++) {
            prefMax = Math.max(prefMax, nums[i]);
            
            // Check instability score condition
            if (prefMax - suffMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}