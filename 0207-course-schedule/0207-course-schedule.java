class Solution {
    class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public boolean isOk(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (dfs(graph, i, vis, stack)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle
    }

    public boolean dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {

        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest]) {
                if (dfs(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }

        stack[curr] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];

            graph[src].add(new Edge(src, dest));
        }

        return !isOk(graph);  
    }
}