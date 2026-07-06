class Solution {

    class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create Graph
        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Indegree Array
        int[] indegree = new int[numCourses];

        // Build Graph
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph[prerequisite].add(new Edge(prerequisite, course));

            indegree[course]++;
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            ans[idx++] = curr;

            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);

                indegree[e.dest]--;

                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // Cycle exists
        if (idx != numCourses) {
            return new int[0];
        }

        return ans;
    }
}