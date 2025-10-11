package Graph;
import java.util.*;
import Graph.AdjacencyList.Edge;

class KosaRaju{
    public static void graph(ArrayList<Edge> gg[],int V){
        for(int i =0; i<V; i++){
            gg[i] = new ArrayList<>();
        }
        gg[0].add(new Edge(0, 2));
        gg[0].add(new Edge(0, 3));

        gg[1].add(new Edge(1, 0));

        gg[2].add(new Edge(2, 1));

        gg[3].add(new Edge(3, 4));
    }

    public static void topo(ArrayList<Edge> gg[] , int curr , boolean[] vis , Stack<Integer> kk){
        vis[curr] = true;

        for(Edge nei : gg[curr]){
            if(vis[nei.dest] == false){
                topo(gg,nei.dest,vis,kk);
            }
        }
        kk.push(curr);
    }

    public static void dfs(ArrayList<Edge> gg[] , int curr , boolean[] vis){
        vis[curr] = true;
        System.out.print(curr + " ");

        for(Edge nei : gg[curr]){
            if(vis[nei.dest] == false){
                dfs(gg,nei.dest,vis);
            }
        }
    }

    public static void KosaRajuAlgo(ArrayList<Edge> gg[] , int V){
        // Step 1
        Stack<Integer> kk = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                topo(gg, i, vis, kk);
            }
        }

        // Step - 2 transpose the copy of graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i =0; i<V; i++){
            transpose[i] = new ArrayList<>();
        }

        for(int i = 0; i<V; i++){
            vis[i] = false;
            for(int j = 0; j<gg[i].size(); j++){
                Edge e = gg[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 run dfs on transpose graph poping out from each element in stack
        while(!kk.isEmpty()){
            int curr = kk.pop();

            if(!vis[curr]){
                System.out.print("SCC : ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> gg[] = new ArrayList[V];
        graph(gg,V);

        System.out.println("TopoLogical");
        boolean[] vis= new boolean[V];
        Stack<Integer> kk = new Stack<>();

        for(int i = 0; i<V; i++){
            if(vis[i]== false){
                topo(gg,0,vis , kk);
            }
        }
        while(!kk.isEmpty()){
            System.out.print(kk.pop() + " ");
        }
        System.out.println();
        System.out.println("DFS");
        dfs(gg, 0, new boolean[V]);
        System.out.println();
        System.out.println("Kosaraju");

        KosaRaju.KosaRajuAlgo(gg,V);

    }
}
