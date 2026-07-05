package Graph;
import java.util.*;

public class TopologicalSort {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 0));

        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void kahn(ArrayList<Edge>[] graph){
        int[] inDegree = new int[graph.length];

        //finding in degree
        for(int i = 0; i< graph.length; i++){
            for(int j = 0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<graph.length; i++){
            if(inDegree[i] ==  0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int a = 0; a < graph[curr].size(); a++){
                Edge f = graph[curr].get(a);
                inDegree[f.dest]--;

                if(inDegree[f.dest] == 0){
                    q.add(f.dest);
                }

            }

        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        kahn(graph);
    }
}
