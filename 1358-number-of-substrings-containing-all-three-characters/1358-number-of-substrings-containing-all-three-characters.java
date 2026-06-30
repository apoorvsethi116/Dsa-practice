class Solution {
    public int numberOfSubstrings(String s) {
        // Track the last seen index of 'a', 'b', and 'c'
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;
        int count = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            
            if (ch == 'a') lastA = right;
            else if (ch == 'b') lastB = right;
            else if (ch == 'c') lastC = right;
            
            // If we have seen all three characters at least once
            if (lastA != -1 && lastB != -1 && lastC != -1) {
                // The number of valid substrings ending at 'right' is determined
                // by the minimum index among the three characters.
                int minIndex = Math.min(lastA, Math.min(lastB, lastC));
                count += minIndex + 1;
            }
        }
        
        return count;
    }
}