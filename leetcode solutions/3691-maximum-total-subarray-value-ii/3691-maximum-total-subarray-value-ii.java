import java.util.PriorityQueue;

class Solution {
    private int[][] minTable;
    private int[][] maxTable;
    private int[] logTable;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }
        
        int maxLog = logTable[n];
        minTable = new int[maxLog + 1][n];
        maxTable = new int[maxLog + 1][n];
        
        for (int i = 0; i < n; i++) {
            minTable[0][i] = nums[i];
            maxTable[0][i] = nums[i];
        }
        
        for (int j = 1; j <= maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                minTable[j][i] = Math.min(minTable[j - 1][i], minTable[j - 1][i + (1 << (j - 1))]);
                maxTable[j][i] = Math.max(maxTable[j - 1][i], maxTable[j - 1][i + (1 << (j - 1))]); // Fixed typo here
            }
        }
        
        // Max-Heap stores elements as: long[] {subarray_value, left_index, right_index}
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        
        for (int l = 0; l < n; l++) {
            long val = queryValue(l, n - 1);
            maxHeap.offer(new long[]{val, l, n - 1});
        }
        
        long totalValue = 0;
        
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            
            long[] current = maxHeap.poll();
            long val = current[0];
            int l = (int) current[1];
            int r = (int) current[2];
            
            totalValue += val;
            
            if (r > l) {
                long nextVal = queryValue(l, r - 1);
                maxHeap.offer(new long[]{nextVal, l, r - 1});
            }
        }
        
        return totalValue;
    }
    
    private long queryValue(int l, int r) {
        if (l > r) return 0;
        int len = r - l + 1;
        int k = logTable[len];
        
        // Fixed lookup indexing here
        int maxVal = Math.max(maxTable[k][l], maxTable[k][r - (1 << k) + 1]);
        int minVal = Math.min(minTable[k][l], minTable[k][r - (1 << k) + 1]);
        
        return (long) maxVal - minVal;
    }
}