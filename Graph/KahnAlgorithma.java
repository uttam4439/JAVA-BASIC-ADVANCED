package Graph;
import Graph.AdjacencyList.Edge;
import java.util.*;

class KahnAlgorithma{
    
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

    public static void KahnAlgo(){
        
    }
}