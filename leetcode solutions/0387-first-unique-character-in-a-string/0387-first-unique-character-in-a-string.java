class Solution {
    public int firstUniqChar(String s) {
        // An array to store frequencies of all 26 lowercase English letters
        int[] freq = new int[26];
        
        // Pass 1: Count occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Pass 2: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i; // Found it! Return the current index
            }
        }
        
        // If no unique character exists
        return -1;
    }
}