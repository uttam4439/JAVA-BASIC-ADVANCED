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

    public static void dfs(ArrayList<Edge> graph[] , int curr ,boolean visdfs[]){ // vis is use to dont cycle
        System.out.print(curr + " ");
        visdfs[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visdfs[e.dest]){
                dfs(graph, e.dest, visdfs);
            }
        }
    }

    public static void dfs2(ArrayList<Edge> graph[] , int curr ,boolean visdfs2[]){ 
        System.out.print(curr + " ");
        visdfs2[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visdfs2[e.dest]){
                dfs(graph, e.dest, visdfs2);
            }
        }
    }

    //O(V^V)
    public static void AllPath(ArrayList<Edge> graph[], boolean visi[] ,int curr, String path , int target){
        // Base case: if we reached the target, print the path and stop recursion
        if(curr == target){
        System.out.println(path);
        return;
        }
        // Explore all neighbors of the current node
        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // If neighbor is not visited, we can go there
            if(!visi[e.dest]){
                visi[curr] = true;

                // Recursive call: go deeper to destination node
                // Add `e.dest` to path string
                AllPath(graph, visi, e.dest, path+e.dest, target);

                // Backtrack: unmark current node as visited 
                // (so it can be used in other possible paths)
                visi[curr] = false;
            }
        }
}
/* Outside-loop marking makes it robust. It works for any graph (with cycles, multiple branches, etc.).

public static void AllPath(ArrayList<Edge> graph[], boolean visi[] ,int curr, String path , int target){
        if(curr == target){
        System.out.println(path);
        return;
        }
        visi[curr] = true;
       
        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                AllPath(graph, visi, e.dest, path+e.dest, target);
            }
        }
            visi[curr] = false;
} */

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
        System.out.println("Graph (Adjacency List):");
        CreateGraph(graph);

        // Print unweighted graph adjacency list
        for(int i = 0; i < v; i++){
            System.out.print(i + " -> ");
            for(Edge e : graph[i]){
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<WeightEdge> network[] = new ArrayList[v];
        System.out.println("Weighted Graph (Adjacency List):");
        WeightedGraph(network);
    
        // Print weighted graph adjacency list
        for(int i = 0; i < v; i++){
            System.out.print(i + " -> ");
            for(WeightEdge w : network[i]){
                System.out.print("(" + w.dest + ", w=" + w.weight + ") ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i = 0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
        System.out.println();

        for(int i = 0; i < network[3].size(); i++){
            WeightEdge w = network[3].get(i);
            System.out.println(w.src + " " + w.dest + " " + w.weight + " ");
        }
        System.out.print("BFS Traversal (from 0): ");
        bfs(graph, v);
        System.out.println();


        // it is required in main method when diconnected graph BFS
        System.out.print("BFS Traversal (Disconnected Graph): ");
        boolean vis[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(vis[i] == false){
                bfs(graph, v, vis, i);
            }
        }
        System.out.println();

        System.out.print("DFS Traversal (from 0): ");
        boolean visdfs[] = new boolean[v];
        dfs(graph, 0, visdfs);
        System.out.println();

        // it is required in main method when diconnected graph DFS
        System.out.print("DFS Traversal (Disconnected Graph): ");
        boolean visdfs2[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(visdfs2[i] == false){
                dfs2(graph, i, visdfs2);
            }
        }
        System.out.println();

        //print all path
        System.out.println("All Paths from 0 to 1:");
        boolean visi[] = new boolean[v];
        int src = 0; int target = 1;
        AllPath(graph, visi, src, "0", target);
    }
}