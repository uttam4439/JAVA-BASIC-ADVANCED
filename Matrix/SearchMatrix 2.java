package Matrix;

public class SearchMatrix{
    public static void main(String[] args){

        // Set row nd col zero when a element in that row or col is 0;
        int[][] mat = {{1,1,1},{1,0,1},{1,1,1}};
        SearchMatrix.Setzero(mat);

        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(SearchMatrix.Sorted(arr, 100));

        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Setzero(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;

        boolean[] rowz = new boolean[row];
        boolean[] colz = new boolean[col];
        
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    rowz[i] = true;
                    colz[j] = true;
                }
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(rowz[i] || colz[j]){
                    mat[i][j] = 0;
                }
            }
        }

        }
        // Searching in Sorted[row][cols] 2D Array 
        public static boolean Sorted(int[][] arr,int target){
            int n = arr.length;
            int m = arr[0].length;

            int row = 0;
            int col = m - 1;
            while(row < n && col >= 0 ){
                if(arr[row][col] == target){
                    return true;
                }else if(arr[row][col] < target){
                    row++;
                }else{
                    col--;
                }
            }
            return false;
    }
}