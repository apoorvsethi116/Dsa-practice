import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 1. Sort both arrays to clear up the order matching issue
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childPointer = 0; // Tracks the current child we are trying to satisfy
        int cookiePointer = 0; // Tracks the current cookie we are evaluating
        
        // 2. Step through both arrays using independent pointers
        while (childPointer < g.length && cookiePointer < s.length) {
            // If the cookie is big enough, the child is content!
            if (s[cookiePointer] >= g[childPointer]) {
                childPointer++; // Move to the next child
            }
            // Always move to the next cookie, whether it was used or too small
            cookiePointer++;
        }
        
        // The child pointer naturally equals the total number of content children
        return childPointer;
    }
}