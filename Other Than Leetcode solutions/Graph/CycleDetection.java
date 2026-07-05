package Graph;

import java.util.ArrayList;

public class CycleDetection {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph , i, vis , -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis , int par){
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest] && detectCycleUtil(graph , e.dest , vis , curr)){
                return true;
            }
            if(vis[e.dest] && e.dest != par){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleInDirected(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if(isCycleInDirectedUtil(graph, i, vis, stack)){
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isCycleInDirectedUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis , boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleInDirectedUtil(graph , e.dest , vis , stack)){
                return true;
            }


        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

//        // 0 <-> 1
//        graph[0].add(new Edge(0, 1));
//        graph[1].add(new Edge(1, 0));
//
//        // 0 <-> 2
//        graph[0].add(new Edge(0, 2));
//        graph[2].add(new Edge(2, 0));
//
//        // 0 <-> 3
//        graph[0].add(new Edge(0, 3));
//        graph[3].add(new Edge(3, 0));
//
//        // 1 <-> 2
//        graph[1].add(new Edge(1, 2));
//        graph[2].add(new Edge(2, 1));
//
//        // 3 <-> 4
//        graph[3].add(new Edge(3, 4));
//        graph[4].add(new Edge(4, 3));

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 2));

        //System.out.println(detectCycle(graph));
        System.out.println(isCycleInDirected(graph));
    }
}
