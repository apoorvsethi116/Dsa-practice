class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
            halfFreq[i] = freq[i] / 2;
        }

        // A valid palindrome cannot be formed if more than 1 character has an odd frequency
        if (oddCount > 1) {
            return "";
        }

        int m = n / 2;
        String result = "";

        // Iterate through prefix lengths matching target[0...k-1] from m down to 0
        for (int k = m; k >= 0; k--) {
            int[] currHalf = halfFreq.clone();
            StringBuilder prefix = new StringBuilder();
            boolean validPrefix = true;

            // Match prefix with target[0...k-1]
            for (int i = 0; i < k; i++) {
                int idx = target.charAt(i) - 'a';
                if (currHalf[idx] > 0) {
                    currHalf[idx]--;
                    prefix.append(target.charAt(i));
                } else {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) continue;

            // Case 1: First half matches target completely
            if (k == m) {
                String cand = makePalindrome(prefix.toString(), midChar, n);
                if (cand.compareTo(target) > 0) {
                    if (result.isEmpty() || cand.compareTo(result) < 0) {
                        result = cand;
                    }
                }
                continue;
            }

            // Case 2: Diverge at position k by picking a character strictly greater than target[k]
            char targetChar = target.charAt(k);
            for (int c = targetChar - 'a' + 1; c < 26; c++) {
                if (currHalf[c] > 0) {
                    int[] tempHalf = currHalf.clone();
                    tempHalf[c]--;

                    StringBuilder candHalf = new StringBuilder(prefix);
                    candHalf.append((char) ('a' + c));

                    // Fill remaining slots (k+1 to m-1) in ascending order for smallest result
                    for (int ch = 0; ch < 26; ch++) {
                        while (tempHalf[ch] > 0) {
                            candHalf.append((char) ('a' + ch));
                            tempHalf[ch]--;
                        }
                    }

                    String cand = makePalindrome(candHalf.toString(), midChar, n);
                    if (cand.compareTo(target) > 0) {
                        if (result.isEmpty() || cand.compareTo(result) < 0) {
                            result = cand;
                        }
                    }
                }
            }

           
            if (!result.isEmpty()) {
                return result;
            }
        }

        return result;
    }

    private String makePalindrome(String half, char midChar, int n) {
        StringBuilder full = new StringBuilder(half);
        if (n % 2 != 0) {
            full.append(midChar);
        }
        full.append(new StringBuilder(half).reverse());
        return full.toString();
    }
}