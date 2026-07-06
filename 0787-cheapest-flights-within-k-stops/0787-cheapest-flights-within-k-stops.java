class Solution {

    class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    class Info {
        int node;
        int cost;
        int stops;

        Info(int n, int c, int s) {
            node = n;
            cost = c;
            stops = s;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create Graph
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            graph[u].add(new Edge(u, v, w));
        }

        // Distance Array
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){

            Info curr = q.remove();

            if(curr.stops > k)
                continue;

            for(int i = 0; i < graph[curr.node].size(); i++){

                Edge e = graph[curr.node].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k){

                    dist[v] = curr.cost + wt;

                    q.add(new Info(v,
                                   dist[v],
                                   curr.stops + 1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE)
            return -1;

        return dist[dst];
    }
}