class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // memo[i] stores the max indices visited starting from index i
        int[] memo = new int[n];
        int maxVisited = 0;
        
        // Try starting from every possible index to find the maximum
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, memo));
        }
        
        return maxVisited;
    }
    
    private int dfs(int[] arr, int d, int i, int[] memo) {
        // If already calculated, return the cached result
        if (memo[i] != 0) {
            return memo[i];
        }
        
        int n = arr.length;
        int maxFromHere = 1; // You can always visit at least yourself
        
        // 1. Jump to the right: i + 1 up to i + d
        for (int j = i + 1; j <= i + d && j < n; j++) {
            // We hit a wall: cannot jump to or past any element >= arr[i]
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, memo));
        }
        
        // 2. Jump to the left: i - 1 down to i - d
        for (int j = i - 1; j >= i - d && j >= 0; j--) {
            // We hit a wall: cannot jump to or past any element >= arr[i]
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, memo));
        }
        
        // Cache and return the result
        memo[i] = maxFromHere;
        return maxFromHere;
    }
}