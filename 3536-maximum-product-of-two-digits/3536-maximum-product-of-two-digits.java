class Solution {
    public int maxProduct(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int max1 = -1;
        int max2 = -1;

        for (char ch : digits) {
            int digit = ch - '0';

            if (digit >= max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
        }

        return max1 * max2;
    }
}