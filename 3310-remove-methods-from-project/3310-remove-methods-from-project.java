class Solution {

    public void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] suspicious) {

        suspicious[node] = true;

        ArrayList<Integer> neighbours = graph.get(node);

        for (int i = 0; i < neighbours.size(); i++) {

            int next = neighbours.get(i);

            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < invocations.length; i++) {

            int from = invocations[i][0];
            int to = invocations[i][1];

            graph.get(from).add(to);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        for (int i = 0; i < invocations.length; i++) {

            int from = invocations[i][0];
            int to = invocations[i][1];

            if (!suspicious[from] && suspicious[to]) {

                List<Integer> ans = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }

                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}