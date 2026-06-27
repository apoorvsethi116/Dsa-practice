import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxLength = 1;

        // Step 2: Handle the special case for 1
        if (counts.containsKey(1)) {
            int oneCount = counts.get(1);
            // We can only pick an odd number of 1s
            if (oneCount % 2 == 0) {
                maxLength = Math.max(maxLength, oneCount - 1);
            } else {
                maxLength = Math.max(maxLength, oneCount);
            }
        }

        // Step 3: Check sequences for numbers > 1
        for (int num : counts.keySet()) {
            if (num == 1) continue;

            int currentLength = 0;
            long current = num;

            // Keep squaring as long as we have at least 2 copies of the current number
            while (current <= 1_000_000_000 && counts.getOrDefault((int) current, 0) >= 2) {
                currentLength += 2;
                current = current * current; // Square it
            }

            // The loop breaks when we don't have >= 2 copies. 
            // If we have exactly 1 copy left, it can act as the single peak element!
            if (current <= 1_000_000_000 && counts.getOrDefault((int) current, 0) >= 1) {
                currentLength += 1;
            } else {
                // If we don't even have 1 copy of the next squared number, 
                // the previous number we processed must become the peak instead.
                // Since we already gave it 2 elements (one for left, one for right), 
                // we "steal" one of them to act as the peak.
                currentLength -= 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}