class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Pre-allocate array to map each node to its unique component group
        int[] componentId = new int[n];
        int currentId = 0;
        componentId[0] = currentId;
        
        // Since nums is sorted, elements in the same component must be contiguous
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentId++; // The gap is too large; start a new component group
            }
            componentId[i] = currentId;
        }
        
        // Process each query in O(1) time
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // If they belong to the same component, a valid path exists
            answer[i] = (componentId[u] == componentId[v]);
        }
        
        return answer;
    }
}