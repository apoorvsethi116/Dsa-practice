package Recursion;
/* all n size binary string without consecutive one*/
public class BinaryStrings {
    public static void printBinaryStrings(int n, int lastPlace, StringBuilder sb) {
        if (n == 0) {
            System.out.println(sb.toString());
            return;
        }

        // Place 0
        sb.append('0');
        printBinaryStrings(n - 1, 0, sb);
        sb.deleteCharAt(sb.length() - 1); // backtrack

        // Place 1 only if last was 0
        if (lastPlace == 0) {
            sb.append('1');
            printBinaryStrings(n - 1, 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }

    public static void main(String args[]) {
        int n = 3;
        printBinaryStrings(n, 0, new StringBuilder());
    }
}
