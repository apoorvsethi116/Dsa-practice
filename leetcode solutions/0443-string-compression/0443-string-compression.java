class Solution {
    public int compress(char[] chars) {
        int write = 0; // Position to write compressed characters
        int i = 0;     // Start of current group

        while (i < chars.length) {

            int j = i;

            // Find the end of the current group
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            // Write the character
            chars[write++] = chars[i];

            // Count of current group
            int count = j - i;

            // If count > 1, write its digits
            if (count > 1) {
                String s = Integer.toString(count);

                for (char c : s.toCharArray()) {
                    chars[write++] = c;
                }
            }

            // Move to next group
            i = j;
        }

        return write;
    }
}