package Graph;

import java.util.ArrayList;

public class BellmanFord {

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


    //neagtive weight graph
    public static void createGraph(ArrayList<Edge>[] graph){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,4));
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,-2));
        graph[1].add(new Edge(1,3,2));

        graph[2].add(new Edge(2,3,3));
        graph[2].add(new Edge(2,4,2));

        graph[4].add(new Edge(4,3,-1));
        graph[3].add(new Edge(3,5,2));

        graph[4].add(new Edge(4,5,4));
    }

    //neagtive cycle graph
    public static void createGraph2(ArrayList<Edge>[] graph){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));

        graph[1].add(new Edge(1, 2, -2));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 1, -3)); // Creates the negative cycle

        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 5, 3));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph , int src){
        int[] dist = new int[graph.length];
        for(int i = 0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //looping uptill V - 1
        for(int i = 0; i<graph.length -1; i++){


            //relaxation
            for(int j = 0; j<graph.length; j++){

                //every edge
                for(int k = 0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        //negative cycle detection
        //looping one more time
        for(int j = 0; j < graph.length; j++){

            for(int k = 0; k < graph[j].size(); k++){

                Edge e = graph[j].get(k);

                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if(dist[u] != Integer.MAX_VALUE &&
                        dist[u] + w < dist[v]){

                    System.out.println("Negative Cycle Found");
                    return;
                }
            }
        }

        for(int d = 0; d<dist.length; d++){
            System.out.print(dist[d] + " ");
        }
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        bellmanFord(graph , 0);
    }

}
