import java.util.*;

public class MatrixArray{
    public static void main(String[] args){
        
        Scanner gg = new Scanner(System.in);
            System.out.print("Enter no. rows");
            int rows = gg.nextInt();
            System.out.print("Enter no. column");
            int colm = gg.nextInt();

            int[][] numbers = new int[rows][colm];

            for(int i=0; i<rows; i++){
                for(int j=0; j<colm; j++){
                    numbers[i][j] = gg.nextInt();
                }
            }

            for(int i=0; i<rows; i++){
                for(int j=0; j<colm; j++){
                    System.out.print(numbers[i][j] + " ");
                } 
                System.out.println();
            }
        
    }
}