class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        // Pass 1: Fill elements smaller than pivot from the left
        // and elements greater than pivot from the right (in reverse)
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[n - 1 - i] > pivot) {
                result[right--] = nums[n - 1 - i];
            }
        }
        
        // Pass 2: Fill the remaining middle positions with the pivot element
        while (left <= right) {
            result[left++] = pivot;
        }
        
        return result;
    }
}