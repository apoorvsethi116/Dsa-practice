package Graph;
import java.util.*;


public class PrimsMST {
    public static class Edge {
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
        int cost;

        Pair(int n, int c) {
            node = n;
            cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,0,10));

        graph[0].add(new Edge(0,2,15));
        graph[2].add(new Edge(2,0,15));

        graph[0].add(new Edge(0,3,30));
        graph[3].add(new Edge(3,0,30));

        graph[1].add(new Edge(1,3,40));
        graph[3].add(new Edge(3,1,40));

        graph[2].add(new Edge(2,3,5));
        graph[3].add(new Edge(3,2,5));
    }

    //prims
    public static int prim(ArrayList<Edge>[] graph){
        int totalCost = 0;
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //add first pair
        pq.add(new Pair(0 , 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.node]){
                vis[curr.node] = true;
                totalCost += curr.cost;

                for(int i = 0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        System.out.println(prim(graph));
    }

}
