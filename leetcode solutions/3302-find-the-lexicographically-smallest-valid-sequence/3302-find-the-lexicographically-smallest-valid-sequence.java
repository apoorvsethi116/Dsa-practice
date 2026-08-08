class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[m];
        Arrays.fill(suffix, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];
        int k = 0;
        int prev = -1;
        boolean changed = false;

        for (i = 0; i < n && k < m; i++) {

            if (word1.charAt(i) == word2.charAt(k)) {
                ans[k] = i;
                k++;
            } 
            else if (!changed && (k == m - 1 || 
                     (suffix[k + 1] != -1 && i < suffix[k + 1]))) {
                
                ans[k] = i;
                k++;
                changed = true;
            }
        }

        if (k != m) {
            return new int[0];
        }

        return ans;
    }
}