package Graph;
import java.util.*;

public class CyclicGraph{
    static class DirectedEdge{
        int src;
        int dest;

        public DirectedEdge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void directedGraph(ArrayList<DirectedEdge> graph[]){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<DirectedEdge>();
        }
        graph[0].add(new DirectedEdge(0, 2));
        graph[1].add(new DirectedEdge(1,0));
        graph[2].add(new DirectedEdge(2,3));
        graph[3].add(new DirectedEdge(3,0));
        
    }

    public static boolean isCyclic(ArrayList<DirectedEdge> graph[], boolean[] vis, int curr, boolean[] rec){
        // boolean rec[] array track krne ke liye h curr. element ke neighbour ki cyclic h ya nhi

        vis[curr] = true;
        rec[curr] = true;

        for(int i =0; i<graph[curr].size(); i++){
            DirectedEdge e = graph[curr].get(i);

            if(rec[e.dest] == true){
                return true;
            }else if(vis[e.dest] == false){
                if(isCyclic(graph, vis, e.dest, rec) == true){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void directedGraph2(ArrayList<DirectedEdge> grapht[]){
        for(int i =0; i<grapht.length; i++){
            grapht[i] = new ArrayList<DirectedEdge>();
        }
        grapht[2].add(new DirectedEdge(2, 3));
        grapht[3].add(new DirectedEdge(3, 1));
        grapht[4].add(new DirectedEdge(4, 0));
        grapht[4].add(new DirectedEdge(4, 1));
        grapht[5].add(new DirectedEdge(5, 0));
        grapht[5].add(new DirectedEdge(5, 2));
    }

    public static void TopologicalSort(ArrayList<DirectedEdge> graph[] , boolean[] visi , int curr , Stack<Integer> gg){
        //Topo. sort used when there is no cycle in graph (Directed Acyclic Graph)
        visi[curr] = true;

        for(DirectedEdge i : graph[curr]){
            int y = i.dest;

            if(!visi[y]){
                TopologicalSort(graph, visi, y, gg);
            }
        }
        gg.push(curr);
    }
    public static void main(String[] args){
        int V = 6;

        //yanha array create kr rahe wo bhi ArrayList datatype ka na ki arraylist
        ArrayList<DirectedEdge> graph[] = new ArrayList[V]; 
        directedGraph(graph);

        // if dircted graph has component then way to find at least 1 cycle
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!vis[i]){
                boolean iscycle = isCyclic(graph, vis, 0, rec);
                if(iscycle){
                    System.out.println(iscycle);
                    break;
                }
            }
        }

        // only when all components are in 1
        System.out.println(isCyclic(graph, new boolean[V], 0, new boolean[V]));

        boolean[] visi = new boolean[V];
        Stack<Integer> gg = new Stack<>();

        for(int i = 0; i<V; i++){
            if(!visi[i]){
                TopologicalSort(graph , visi, i , gg );
            }
        }
        while(!gg.isEmpty()){
            System.out.print(gg.pop() + " ");
        }
    }

    
}