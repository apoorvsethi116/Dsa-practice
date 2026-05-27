class Solution {
    public int numberOfSpecialChars(String word) {
        // Arrays to store indices. Initialize with -1 to indicate "not seen".
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        java.util.Arrays.fill(lastLower, -1);
        java.util.Arrays.fill(firstUpper, -1);
        
        // Traverse the string to record the positions
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                // Always update to get the LAST lowercase occurrence
                lastLower[ch - 'a'] = i;
            } else {
                // Only update if it's the FIRST uppercase occurrence
                if (firstUpper[ch - 'A'] == -1) {
                    firstUpper[ch - 'A'] = i;
                }
            }
        }
        
        int specialCount = 0;
        
        // Check the condition for all 26 alphabets
        for (int i = 0; i < 26; i++) {
            // Condition 1: Both lowercase and uppercase must exist
            // Condition 2: Last lowercase index must be strictly less than first uppercase index
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}