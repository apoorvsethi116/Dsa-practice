class Solution {

    public boolean dfs(ArrayList<Integer>[] graph, int curr, int dest, boolean[] vis) {

        if (curr == dest) {
            return true;
        }

        vis[curr] = true;

        for (int neighbour : graph[curr]) {
            if (!vis[neighbour]) {
                if (dfs(graph, neighbour, dest, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int V = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[V];

            // Is there already a path from u to v?
            if (dfs(graph, u, v, vis)) {
                return edge;
            }

            // No path, so safely add the edge
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }
}