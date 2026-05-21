import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // edge cases
        if(nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;

        // answer array size
        int[] result = new int[n - k + 1];

        // stores INDEXES
        Deque<Integer> dq = new LinkedList<>();

        int idx = 0;

        for(int i = 0; i < n; i++) {

            // remove indexes outside current window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // window formed
            if(i >= k - 1) {
                result[idx] = nums[dq.peekFirst()];
                idx++;
            }
        }

        return result;
    }
}