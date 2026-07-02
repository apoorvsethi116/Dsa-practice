package Graph;

import java.util.*;


public class practice {

        public static class Edge{
            int src;
            int dest;
            int wt;

            public Edge(int src , int dest , int wt){
                this.src = src;
                this.dest = dest;
                this.wt = wt;
            }

        }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i =0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph , vis);
            }
        }
    }

        public static void bfsUtil(ArrayList<Edge>[] graph , boolean[] vis){
            Queue<Integer> q = new LinkedList<>();


            q.add(0);

            while(!q.isEmpty()){
                int curr = q.remove();
                if(!vis[curr]){
                    System.out.print(curr + " ");
                    vis[curr] = true;

                    for(int i = 0 ; i<graph[curr].size(); i++){
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }
                }
            }
        }

        public static void dfs(ArrayList<Edge>[] graph){
            boolean[] vis = new boolean[graph.length];
            for(int i =0; i<graph.length; i++){
                if(!vis[i]){
                    dfsUtil(graph , i , vis);
                }
            }
        }


        public static void dfsUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis){
            System.out.print(curr + " ");
            vis[curr] = true;

            for(int i =0 ; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]) {
                    dfsUtil(graph, e.dest, vis);
                }
            }
        }

        public static void main(String[] args) {
        /*
       (5)
    0 ------- 1
    |        / \
 (5)|     (1)/   \(3)
    |      /       \
    |    /   (1)    \
    2 -------------- 3
    |
 (2)|
    |
    4
*/
            int V = 5;
            ArrayList<Edge>[] graph = new ArrayList[V];
            for(int i = 0; i<V; i++){
                graph[i] = new ArrayList<>();
            }

            //0 -> vertex
            graph[0].add(new Edge(0 , 1 , 5));

            //1 vertex
            graph[1].add(new Edge(1 , 0 , 5));
            graph[1].add(new Edge(1 , 2 , 1));
            graph[1].add(new Edge(1 , 3 , 3));

            // Vertex 2
            graph[2].add(new Edge(2, 0, 5));
            graph[2].add(new Edge(2, 1, 1));
            graph[2].add(new Edge(2, 3, 1));
            graph[2].add(new Edge(2, 4, 2));

            // Vertex 3
            graph[3].add(new Edge(3, 1, 3));
            graph[3].add(new Edge(3, 2, 1));

            // Vertex 4
            graph[4].add(new Edge(4, 2, 2));

            bfs(graph); // O(V + E)
            System.out.println();
            dfs(graph);// O(V+E)



        }
    }


