class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of every value
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // gcdCount[g] = number of pairs whose gcd is exactly g
        long[] gcdCount = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs divisible by g
            gcdCount[g] = cnt * (cnt - 1) / 2;

            // Remove pairs already counted for larger gcds
            for (int multiple = g + g; multiple <= max; multiple += g) {
                gcdCount[g] -= gcdCount[multiple];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}