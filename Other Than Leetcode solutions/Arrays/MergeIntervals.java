package Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case: [[1,3],[2,6],[8,10],[15,18]]
        int[][] testIntervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = sol.merge(testIntervals);

        // Printing the result
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Process intervals
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // If list is empty or no overlap, add new interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                // Overlap exists, update the end time of the last interval
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}