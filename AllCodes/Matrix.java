import java.util.Arrays;

public class Matrix {
    // X-Matrix whose Diagonal is non zero and every other element is 0;
    
    public static void main(String[] args) {
        int[][] arr = {{1,0,1},{0,1,0},{1,0,1}};
        
        Matrix c = new Matrix();
        c.call(arr);

    }
    public void call(int[][] arr){
        System.out.println(isX(arr));

        matrixTraverse kk = new matrixTraverse();
        System.out.println(Arrays.toString(kk.Traverse(arr)));
    }
        private boolean isX(int[][] arr){
        for(int i = 0; i<arr.length; i++){
            if(arr[i][i] == 0 || arr[i][(arr.length-1)-i] == 0){
                return false;
            }
        }
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr.length; j++){
                if(i != j && i+j != arr.length-1){
                    if(arr[i][j] != 0){
                    return false;
                }
            }
        }
        
    }
    return true;
    }

    private class matrixTraverse{

        private int[] Traverse(int[][] arr){
            int rows = arr.length;
            int cols = arr[0].length;   // kisi ek row ka length nikalo to cols mil jayega
            int[] ans = new int[rows*cols];

            int index = 0;
            for(int i = 0; i<rows; i++){
                for(int j = 0; j<cols; j++){
                    ans[index++] = arr[i][j];
                }
            }
            return ans;
        }
    }
    
}