package Graph;
import Graph.AdjacencyList.WeightEdge;
import java.util.*;

class BellmanFord{
    
    public static void dgraph(ArrayList<WeightEdge> gg[], int V){
        for(int i = 0; i<V; i++){
            gg[i]= new ArrayList<>();
        }
        gg[0].add(new WeightEdge(0, 1, 2));
        gg[0].add(new WeightEdge(0, 2, 4));

        gg[1].add(new WeightEdge(1, 2, -4));

        gg[2].add(new WeightEdge(2, 3, 2));

        gg[3].add(new WeightEdge(3, 4, 4));

        gg[4].add(new WeightEdge(4, 1, -1));
    }

    public static void bellmanAlgo(ArrayList<WeightEdge> gg[] , int src){
        int[] sortdist = new int[gg.length];

        for(int i = 0; i<gg.length; i++){
            if(i != src){
                sortdist[i] = Integer.MAX_VALUE;
            }
        }
        sortdist[src] = 0;
        
        for(int i = 0; i<gg.length-1; i++){
            for(int j =0; j<gg.length; j++){
                for(int k = 0; k<gg[j].size(); k++){
                    WeightEdge e = gg[j].get(k);
                    int x = e.src;
                    int y = e.dest;
                    int w = e.weight;

                    // only relax edges from nodes that are already reachable i.e distance[x] != ∞
                    if(sortdist[x] != Integer.MAX_VALUE && sortdist[x] + w < sortdist[y]){
                        sortdist[y] = sortdist[x] + w;
                    }
                }
            }
        }
        for(int i = 0; i<sortdist.length; i++){
            System.out.print(sortdist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<WeightEdge> gg[] = new ArrayList[V];
        dgraph(gg, V);

        bellmanAlgo(gg, 0);
    }
}