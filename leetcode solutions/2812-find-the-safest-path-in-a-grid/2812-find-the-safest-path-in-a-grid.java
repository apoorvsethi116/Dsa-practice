import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge case: If start or end contains a thief, safeness factor is 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[n][n];
        for (int[] row : safeness) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize Multisource BFS with all thief locations
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    safeness[r][c] = 0;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Calculate minimum distance to any thief for each cell
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == Integer.MAX_VALUE) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Max-Heap (Dijkstra-like approach) to find the maximum safeness path
        // Priority Queue stores: {safeness_factor, r, c} sorted descending by safeness_factor
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{safeness[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int maxSafeSoFar = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached the destination
            if (r == n - 1 && c == n - 1) {
                return maxSafeSoFar;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The safeness of a path is limited by its minimum value cell
                    int nextSafe = Math.min(maxSafeSoFar, safeness[nr][nc]);
                    maxHeap.offer(new int[]{nextSafe, nr, nc});
                }
            }
        }

        return 0;
    }
}