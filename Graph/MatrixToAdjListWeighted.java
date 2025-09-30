package Graph;
import java.util.*;
public class MatrixToAdjListWeighted {
    public static void main(String[] args) {
        int V = 4; // number of vertices

        // Example weighted adjacency matrix
        // 0 means "no edge"
        int[][] matrix = {
            {0, 2, 0, 5},  // edges from node 0: (0→1, weight=2), (0→3, weight=5)
            {2, 0, 3, 0},  // edges from node 1: (1→0, weight=2), (1→2, weight=3)
            {0, 3, 0, 4},  // edges from node 2: (2→1, weight=3), (2→3, weight=4)
            {5, 0, 4, 0}   // edges from node 3: (3→0, weight=5), (3→2, weight=4)
        };

        // Initialize adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] != 0) { // if edge exists
                    adj.get(i).add(new int[]{j, matrix[i][j]}); // [j = neighbor, matrix[i][j] = weight].
                }
            }
        }

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int[] edge : adj.get(i)) {
                System.out.print("(" + edge[0] + ", w=" + edge[1] + ") ");
            }
            System.out.println();
        }
    }
}
