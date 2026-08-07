class Solution {
    private static final int[] C2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
    private static final int[] C3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
    private static final int[] C5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
    private static final int[] C7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t
        long tempT = t;
        int a = 0, b = 0, c = 0, d = 0;
        while (tempT % 2 == 0) { a++; tempT /= 2; }
        while (tempT % 3 == 0) { b++; tempT /= 3; }
        while (tempT % 5 == 0) { c++; tempT /= 5; }
        while (tempT % 7 == 0) { d++; tempT /= 7; }

        if (tempT > 1) {
            return "-1"; // Invalid prime factor present
        }

        int n = num.length();
        int[] p2 = new int[n + 1];
        int[] p3 = new int[n + 1];
        int[] p5 = new int[n + 1];
        int[] p7 = new int[n + 1];

        int firstZero = n;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '0') {
                firstZero = i;
                break;
            }
            int digit = ch - '0';
            p2[i + 1] = p2[i] + C2[digit];
            p3[i + 1] = p3[i] + C3[digit];
            p5[i + 1] = p5[i] + C5[digit];
            p7[i + 1] = p7[i] + C7[digit];
        }

        // Check if num itself is valid
        if (firstZero == n && p2[n] >= a && p3[n] >= b && p5[n] >= c && p7[n] >= d) {
            return num;
        }

        // Step 2: Try to find a solution of the same length N
        int bestP = -1;
        int bestD = -1;

        for (int p = Math.min(n - 1, firstZero); p >= 0; p--) {
            int req2 = a - p2[p];
            int req3 = b - p3[p];
            int req5 = c - p5[p];
            int req7 = d - p7[p];

            int startDigit = num.charAt(p) - '0' + 1;
            for (int digit = startDigit; digit <= 9; digit++) {
                int nr2 = req2 - C2[digit];
                int nr3 = req3 - C3[digit];
                int nr5 = req5 - C5[digit];
                int nr7 = req7 - C7[digit];

                int remLen = n - 1 - p;
                if (getMinDigits(nr2, nr3, nr5, nr7) <= remLen) {
                    bestP = p;
                    bestD = digit;
                    break;
                }
            }
            if (bestP != -1) {
                break;
            }
        }

        // If a length N solution is found
        if (bestP != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(num, 0, bestP);
            sb.append(bestD);

            int cur2 = a - p2[bestP] - C2[bestD];
            int cur3 = b - p3[bestP] - C3[bestD];
            int cur5 = c - p5[bestP] - C5[bestD];
            int cur7 = d - p7[bestP] - C7[bestD];

            fillGreedy(sb, n - 1 - bestP, cur2, cur3, cur5, cur7);
            return sb.toString();
        }

        // Step 3: If length N is impossible, try length L > N
        int L = Math.max(n + 1, getMinDigits(a, b, c, d));
        StringBuilder sb = new StringBuilder();
        fillGreedy(sb, L, a, b, c, d);
        return sb.toString();
    }

    private void fillGreedy(StringBuilder sb, int len, int r2, int r3, int r5, int r7) {
        for (int i = 0; i < len; i++) {
            int remLen = len - 1 - i;
            for (int digit = 1; digit <= 9; digit++) {
                int nr2 = r2 - C2[digit];
                int nr3 = r3 - C3[digit];
                int nr5 = r5 - C5[digit];
                int nr7 = r7 - C7[digit];

                if (getMinDigits(nr2, nr3, nr5, nr7) <= remLen) {
                    sb.append(digit);
                    r2 = nr2;
                    r3 = nr3;
                    r5 = nr5;
                    r7 = nr7;
                    break;
                }
            }
        }
    }

    private int getMinDigits(int c2, int c3, int c5, int c7) {
        c2 = Math.max(0, c2);
        c3 = Math.max(0, c3);
        c5 = Math.max(0, c5);
        c7 = Math.max(0, c7);

        int count = c5 + c7 + c2 / 3 + c3 / 2;
        int rem2 = c2 % 3;
        int rem3 = c3 % 2;

        if (rem2 == 0 && rem3 == 0) {
            // No extra digits needed
        } else if (rem2 == 2 && rem3 == 1) {
            count += 2; // e.g. 2^2 * 3^1 requires 2 digits (4 & 3 or 6 & 2)
        } else {
            count += 1;
        }
        return count;
    }
}