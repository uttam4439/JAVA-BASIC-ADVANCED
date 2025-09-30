package Graph;
import Graph.AdjacencyList.WeightEdge;  // we don't have to use AdjacencyList.weightEdge
import java.util.*;

class Dijkstra{
    /* implements keyword is used by a class to indicate that it will adhere to the contract defined 
    by an interface.An interface in Java is a blueprint of a class, containing abstract methods 
    (methods without a body) and constant fields.  */

    public static class Pair implements Comparable<Pair> {
        int node;
        int dest;

        public Pair(int n , int d){
            this.node = n;
            this.dest = d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dest - p2.dest;  
            /*  check When you implement compareTo in Java, it must return:
            (a negative number if this < p2) , (zero if this == p2) , (a positive number if this > p2) 
            (negative) → means this < p2 → ✅ correct for ascending. */
        }
    }
    public static void DijkstraGraph(ArrayList<WeightEdge> dgraph[]){
        for(int i = 0; i<dgraph.length; i++){
            dgraph[i] = new ArrayList<WeightEdge>(); 
        }
        dgraph[0].add(new WeightEdge(0, 1, 2)); 
        dgraph[0].add(new WeightEdge(0, 2, 4));  

        dgraph[1].add(new WeightEdge(1, 3, 7));  
        dgraph[1].add(new WeightEdge(1, 2, 1));

        dgraph[2].add(new WeightEdge(2, 4, 3));

        dgraph[3].add(new WeightEdge(3, 5, 1));

        dgraph[4].add(new WeightEdge(4, 3, 2));
        dgraph[4].add(new WeightEdge(4, 5, 5));
    }
    // It obly work for positive graph
    // O(E + ElogV)
    public static void DijkstraAlgo(ArrayList<WeightEdge> dgraph[], int src ,int V){
        PriorityQueue<Pair> kk = new PriorityQueue<>();
        int[] sortdist = new int[V];
        for(int i = 0; i<V; i++){
            if(i != src){
                sortdist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[V]; 
        kk.offer(new Pair(0, 0)); // 0 se 0 tk ka sorted distance

        while(!kk.isEmpty()){
            Pair curr = kk.poll();

            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i = 0; i<dgraph[curr.node].size(); i++){
                    WeightEdge e = dgraph[curr.node].get(i);
                    int u = curr.node;
                    int v = e.dest;

                    if(sortdist[u] + e.weight < sortdist[v]){  // Relaxation
                        sortdist[v] = sortdist[u] + e.weight;
                        kk.offer(new Pair(v, sortdist[v]));  // agar wo distance km h to update kro dest. ka distace
                    }
                }
            }
        }
        for(int i = 0; i<V; i++){
            System.out.print(sortdist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<WeightEdge> dgraph[] = new ArrayList[V];
        DijkstraGraph(dgraph);

        DijkstraAlgo(dgraph, 0, V);
    }
    
}