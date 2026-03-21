package Recursion;

public class Substring {

    public static int countSubstrings(String str, int start, int end) {
        // Base case
        if (start > end) {
            return 0;
        }

        // If single character → always valid
        if (start == end) {
            return 1;
        }

        int count = 0;

        // Check current substring
        if (str.charAt(start) == str.charAt(end)) {
            count = 1;
        }

        // Recursively check:
        // 1. Remove start
        // 2. Remove end
        // 3. Remove both (to avoid double counting)
        return count
                + countSubstrings(str, start + 1, end)
                + countSubstrings(str, start, end - 1)
                - countSubstrings(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "naman";
        int result = countSubstrings(str, 0, str.length() - 1);
        System.out.println("Count: " + result);
    }
}