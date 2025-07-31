package Matrix;

public class SpiralMatrix{
    public static void main(String[] args){

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        // top row -> right col. -> bottom row -> left clo.

        while(top <= bottom && left <= right){
        for(int i = left;  i<right; i++){
            System.out.print(matrix[top][i] + " ");
        }
        top++;
        for(int i = top; i< bottom; i++){
            System.out.print(matrix[i][right] + " ");
        }
        if(top <= bottom){
            for(int i = right; i>= left; i--){
                System.out.print(matrix[bottom][i]+ " ");
            }
            bottom--;
        }

        if(left <= right){
            for(int i = bottom; i>=top; i--){
                System.out.print(matrix[i][left]+ " ");
            }
            left++;
        }
    }
}
}