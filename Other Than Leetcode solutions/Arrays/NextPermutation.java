package Arrays;

import java.util.Arrays;

public class NextPermutation {

        public static void nextPermutation(int[] nums) {
            // 1. Find the first decreasing element from the right (the pivot)
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            // 2. If a pivot was found, find the successor to swap with
            if (i >= 0) {
                int j = nums.length - 1;
                // Find the smallest element to the right that's larger than nums[i]
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }

            // 3. Reverse the elements to the right of the pivot
            // This turns the descending tail into the smallest possible ascending tail
            reverse(nums, i + 1);
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private static void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    public static void main(String[] args) {
        // Example: 2x2 grid (Numbers 1 to 4 should be present)
        // 2 is repeated, 4 is missing
        int[]arr =
                {2,3,4,1};

        ;

       nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }
    }

