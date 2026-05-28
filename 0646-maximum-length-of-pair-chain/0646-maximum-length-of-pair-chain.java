import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Optimize sorting using a primitive integer comparison
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int lastEnd = pairs[0][1];
        int count = 1;
        
        // Start from index 1 to avoid checking the first element against itself
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                count++;
                lastEnd = pairs[i][1];
            }
        }
        
        return count;
    }
}