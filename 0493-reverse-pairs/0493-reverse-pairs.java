class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = 0;

        // 1. Split and count pairs in subarrays
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // 2. Count reverse pairs across the left and right halves
        count += countPairs(nums, low, mid, high);

        // 3. Merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            // Use 2L to cast to long and prevent integer overflow
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            // All elements from (mid + 1) up to (right - 1) satisfy the condition
            count += (right - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Standard merge process
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        // Copy temp back to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}