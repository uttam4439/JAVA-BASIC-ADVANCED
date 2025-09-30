package Graph;
import java.util.*;
public class MatrixToAdjList {
    public static void main(String[] args) {
        int V = 4; // number of vertices

        // Example adjacency matrix
        int[][] matrix = {
            {0, 1, 0, 1},  // connections for node 0
            {1, 0, 1, 0},  // connections for node 1
            {0, 1, 0, 1},  // connections for node 2
            {1, 0, 1, 0}   // connections for node 3
        };

        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] != 0) { // if edge exists
                    adj.get(i).add(j);
                }
            }
        }

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
