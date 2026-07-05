package Graph;

import java.util.*;

public class Bipartite {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 <-> 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        // 0 <-> 2
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        // 1 <-> 3
        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        // 2 <-> 3
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        // 3 <-> 4
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        // 4 <-> 5
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        // 5 <-> 3  (Odd cycle)
        graph[5].add(new Edge(5, 3));
        graph[3].add(new Edge(3, 5));
    }

    public static boolean isBi(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        for(int i = 0; i<color.length; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<graph.length; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j =0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        //case 1 : no color
                        if(color[e.dest] == -1){
                            int newCol = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = newCol;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        System.out.println(isBi(graph));
    }
}