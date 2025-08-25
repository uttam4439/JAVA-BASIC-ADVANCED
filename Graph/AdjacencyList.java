package Graph;

import java.util.*;

public class AdjacencyList{

    static class Edge{
        int src;
        int dest;

        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }

    // BFS traversal of graph without weight
    public static void bfs(ArrayList<Edge> graph[] , int v){
        Queue<Integer> gg = new LinkedList<>();
        boolean vis[] = new boolean[v];
        gg.offer(0);   // Intial data add so that every other vertex can be found

        while(!gg.isEmpty()){
            int curr = gg.poll();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i = 0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    gg.offer(e.dest);
                }
            }
        }
    }

    /* BFS traversal in case it is disconnected Component means there are 
    many graphs but they are part as one. */
    public static void bfs(ArrayList<Edge> graph[] , int v , boolean vis[] , int start ){
        Queue<Integer> gg = new LinkedList<>();
        gg.offer(start);   // As we don't know what is starting point 

        while(!gg.isEmpty()){
            int curr = gg.poll();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i = 0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    gg.offer(e.dest);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[] , int curr ,boolean vis[]){ // vis is use to dont cycle
        System.out.println(curr + " ");
        vis[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[curr] == false){
                dfs(graph, e.dest, vis);
            }
        }
    }

    static class WeightEdge{
        int src;
        int dest;
        int weight;

        public WeightEdge(int s, int d , int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void WeightedGraph(ArrayList<WeightEdge> network[]){
        for(int i = 0; i<network.length; i++){
            network[i] = new ArrayList<WeightEdge>();
        }

        network[0].add(new WeightEdge(0,2,2));

        network[1].add(new WeightEdge(1,2,10));
        network[1].add(new WeightEdge(1,3,0));

        network[2].add(new WeightEdge(2,0,2));
        network[2].add(new WeightEdge(2,1,10));
        network[2].add(new WeightEdge(2,3,-1));

        network[3].add(new WeightEdge(3,1,0));
        network[3].add(new WeightEdge(3,2,-1));
    }

    public static void main(String[] args){
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);

        ArrayList<WeightEdge> network[] = new ArrayList[v];
        WeightedGraph(network);

        for(int i = 0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
        System.out.println();

        for(int i = 0; i < network[3].size(); i++){
            WeightEdge w = network[3].get(i);
            System.out.println(w.src + " " + w.dest + " " + w.weight + " ");
        }
        System.out.println();

        bfs(graph, v);
        System.out.println();

        // it is required in main method when diconnected graph BFS
        boolean vis[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(vis[i] == false){
                bfs(graph, v, vis, i);
            }
        }

        dfs(graph, 0, vis);
        // it is required in main method when diconnected graph DFS
        for(int i = 0; i<v; i++){
            if(vis[i] == false){
                dfs(graph, i, vis);
            }
        }
    }
}