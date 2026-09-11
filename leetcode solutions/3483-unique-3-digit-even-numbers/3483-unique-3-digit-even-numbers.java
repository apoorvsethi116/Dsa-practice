class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[1000];
        int count = 0;

        for (int i = 0; i < digits.length; i++) {

            // last digit must be even
            if (digits[i] % 2 != 0) continue;

            for (int j = 0; j < digits.length; j++) {

                if (j == i) continue;

                // hundreds digit cannot be 0
                if (digits[j] == 0) continue;

                for (int k = 0; k < digits.length; k++) {

                    if (k == i || k == j) continue;

                    int num = digits[j] * 100
                            + digits[k] * 10
                            + digits[i];

                    if (!used[num]) {
                        used[num] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}