import java.util.Arrays;

class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[][][] dp = new int[n + 1][maxNum + 1][maxNum + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; ++i) {
            int current = nums[i];
            for (int x = 0; x <= maxNum; ++x) {
                for (int y = 0; y <= maxNum; ++y) {
                    if (dp[i][x][y] == 0) continue;

                    long currentWays = dp[i][x][y];

                    dp[i + 1][x][y] = (int) ((dp[i + 1][x][y] + currentWays) % MOD);

                    int newX = gcd(x, current);
                    dp[i + 1][newX][y] = (int) ((dp[i + 1][newX][y] + currentWays) % MOD);

                    int newY = gcd(y, current);
                    dp[i + 1][x][newY] = (int) ((dp[i + 1][x][newY] + currentWays) % MOD);
                }
            }
        }

        int ans = 0;
        for (int g = 1; g <= maxNum; ++g) {
            ans = (ans + dp[n][g][g]) % MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}