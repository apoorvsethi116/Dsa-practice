package Graph;

import java.util.ArrayList;

public class AllPath {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));


        graph[1].add(new Edge(1, 3));
    }

    public static void path(ArrayList<Edge>[] graph , int src , int dest , ArrayList<Integer> way){
            way.add(src);
            if(src == dest){
                System.out.println(way);
                way.remove(way.size() - 1);
                return;
            }
            for(int j = 0; j<graph[src].size(); j++){
                Edge e = graph[src].get(j);

                    path(graph, e.dest, dest, way);

            }
            way.remove(way.size() - 1);

        }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        path(graph , 0 , 3 , new ArrayList<Integer>());
    }
}
