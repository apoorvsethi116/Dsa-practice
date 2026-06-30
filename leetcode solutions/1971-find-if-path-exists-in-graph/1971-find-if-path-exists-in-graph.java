class Solution {

    public class Edge {
        int s;
        int d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {

            int curr = q.remove();

            if (curr == destination)
                return true;

            for (Edge e : graph[curr]) {

                if (!vis[e.d]) {

                    vis[e.d] = true;

                    q.add(e.d);

                }

            }

        }

        return false;
    }
}