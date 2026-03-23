package DivideConquer;

public class Sorted_RotatedArray {
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j-1)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted
            if (nums[i] <= nums[mid]) {
                if (target >= nums[i] && target < nums[mid]) {
                    j = mid - 1;   // GO LEFT
                } else {
                    i = mid + 1;   // GO RIGHT
                }
            }
            // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;   // GO RIGHT
                } else {
                    j = mid - 1;   // GO LEFT
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //sorted array {1,2,4,5,6,7,}
        //rotated at i = 3
        int[] arr = {4,5,6,7,0,1,2};
        int target = 1;

        System.out.println(search(arr , target));
    }
}
