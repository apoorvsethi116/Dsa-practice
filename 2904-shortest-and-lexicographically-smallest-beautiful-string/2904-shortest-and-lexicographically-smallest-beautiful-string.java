class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int len = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            int count = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '1') {
                    count++;
                }

                if (count == k) {

                    int currLen = j - i + 1;
                    String curr = s.substring(i, j + 1);

                    if (currLen < len ||
                        (currLen == len && curr.compareTo(ans) < 0)) {

                        len = currLen;
                        ans = curr;
                    }

                    
                    break;
                }
            }
        }

        return ans;
    }
}