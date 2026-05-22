import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefix_sum -> number of times it has occurred)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred 1 time (empty prefix)
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            // Update the running prefix sum
            currentSum += num;
            
            // If (currentSum - k) exists in the map, it means we found 
            // subarray(s) that add up to k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Store/update the frequency of the current prefix sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}