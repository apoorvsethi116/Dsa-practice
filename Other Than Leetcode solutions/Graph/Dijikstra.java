package Graph;
import java.util.*;

public class Dijikstra {
    //T.C = (V+E) + logV


    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int n, int d) {
            node = n;
            dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (vis[curr.node])
                continue;

            vis[curr.node] = true;

            for (Edge e : graph[curr.node]) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;

                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int d : dist)
            System.out.print(d + " ");
    }


    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        graph[3].add(new Edge(3, 5, 1));
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        dijkstra(graph, 0);
    }
}
