package Graph;

import java.util.*;

public class RottingOranges{
    public static int time(int[][] grid ){
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> gg = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    gg.offer(new int[] {i,j});
                }
            }
        }
        if(fresh == 0) return 0;
        int time = 0;

        while(!gg.isEmpty()){
            int size = gg.size();

            for(int i = 0; i<size; i++){
                int rot[] = gg.poll();
                int rr = rot[0];
                int rc = rot[1];

                int neigh[][] = {{rr,rc+1} , {rr,rc-1} ,{rr-1,rc} ,{rr+1,rc}};
                for(int x[] : neigh){
                    int nr = x[0];
                    int nc = x[1];

                    if( nr < 0 || nc < 0 || nr >= n  || nc >= m  || grid[nr][nc] == 0 || grid[nr][nc] == 2) continue;

                    gg.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                    fresh--;

                    if(fresh == 0){
                        return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] grid= {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(time(grid));
    }

}

