class Solution {
    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public void sol(ArrayList<Edge>[] graph, int curr, boolean[] vis, ArrayList<Integer> component) {
        vis[curr] = true;
        component.add(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                sol(graph, e.dest, vis, component);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create undirected graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                ArrayList<Integer> component = new ArrayList<>();

                sol(graph, i, vis, component);

                int vertices = component.size();
                int degreeSum = 0;

                for (int node : component) {
                    degreeSum += graph[node].size();
                }

                if (degreeSum == vertices * (vertices - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}