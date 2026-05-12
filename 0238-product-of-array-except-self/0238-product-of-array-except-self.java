class Solution {
    public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    // 1. Calculate everything to the LEFT
    int leftRunningProduct = 1;
    for (int i = 0; i < n; i++) {
        res[i] = leftRunningProduct; // Put the product of neighbors so far into the box
        leftRunningProduct *= nums[i]; // Update the product for the NEXT box
    }

    // 2. Calculate everything to the RIGHT and combine
    int rightRunningProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] = res[i] * rightRunningProduct; // Current (Left Product) * (Right Product)
        rightRunningProduct *= nums[i]; // Update the right product for the next step back
    }

    return res;
}
}