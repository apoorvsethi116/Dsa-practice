import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> h = new HashMap<>();
        
        // FIX 1: Use put() instead of set()
        for (int a : nums) {
            h.put(a, h.getOrDefault(a, 0) + 1);
        }

        // FIX 3: Pass a custom comparator to sort the KEYS based on their MAP VALUES (Max-Heap)
        // This says: Compare key 'a' and key 'b' by checking their frequencies in map 'h'
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> h.get(b) - h.get(a));

        // FIX 2: Iterate over the map's unique keys, NOT a numeric index loop
        for (int key : h.keySet()) {
            pq.add(key); // We add the actual number (e.g., 100) to the queue
        }

        // Extract the top K elements
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove(); // This cleanly pulls out the most frequent keys
        }

        return res;
    }
}