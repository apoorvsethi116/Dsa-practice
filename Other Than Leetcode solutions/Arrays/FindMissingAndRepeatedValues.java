package Arrays;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {

    // Adding 'static' allows this method to be called directly
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalElements = n * n;
        int[] freq = new int[totalElements + 1];
        int[] ans = new int[2];

        long actualSum = 0;
        int repeated = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                actualSum += val;
                freq[val]++;
                if (freq[val] == 2) {
                    repeated = val;
                }
            }
        }

        long expectedSum = (long) totalElements * (totalElements + 1) / 2;
        int missing = (int) (expectedSum - (actualSum - repeated));

        ans[0] = repeated;
        ans[1] = missing;
        return ans;
    }

    public static void main(String[] args) {
        // Example: 2x2 grid (Numbers 1 to 4 should be present)
        // 2 is repeated, 4 is missing
        int[][] arr = {
                {1, 2},
                {3, 2}
        };

        // Now we can call it directly!
        int[] result = findMissingAndRepeatedValues(arr);

        System.out.println("Result: " + Arrays.toString(result));
    }
}