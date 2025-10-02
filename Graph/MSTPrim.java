package Graph;

import Graph.AdjacencyList.WeightEdge;
import java.util.*;;

public class MSTPrim{
    
    public static void creategraph(ArrayList<WeightEdge> graph[] , int V ){
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightEdge(0, 1, 10));
        graph[0].add(new WeightEdge(0, 2, 15));
        graph[0].add(new WeightEdge(0, 3, 30));

        graph[1].add(new WeightEdge(1, 0, 10));
        graph[1].add(new WeightEdge(1, 3, 40));

        graph[2].add(new WeightEdge(2, 0, 15));
        graph[2].add(new WeightEdge(2, 3, 50));

        graph[3].add(new WeightEdge(3, 1, 40));
        graph[3].add(new WeightEdge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n , int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(this.cost, p2.cost);
        }
    }

    public static void PrimAlgo(ArrayList<WeightEdge> graph[] , int V){
        PriorityQueue<Pair> gg = new PriorityQueue<>(); // work as Non-MST set
        boolean[] vis = new boolean[V];  // work as MST set
        gg.offer(new Pair(0, 0));

        int mstCost = 0;

        while(!gg.isEmpty()){
            Pair curr = gg.poll();

            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(WeightEdge nei : graph[curr.node]){
                    if(!vis[nei.dest]){
                        gg.add(new Pair(nei.dest, nei.weight));
                    }
                    }

                }
            }
            System.out.println("Minimum Cost of This Graph MST" +"->"+ mstCost);
        }

    public static void main(String[] args){
        int V = 4;

        ArrayList<WeightEdge> graph[] = new ArrayList[V];
        creategraph(graph, V);

        PrimAlgo(graph, V);
    }
}