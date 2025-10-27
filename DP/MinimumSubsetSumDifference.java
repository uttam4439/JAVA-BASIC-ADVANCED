package DP;
import java.util.*;

class MinimumSubsetSumDifference{
    public static void main(String[] args){
        int[] arr = {1,2,7};
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();

        int x = difference(arr, sum, n);
        System.out.println(x);
    }

    public static int difference(int arr[] , int sum , int n){
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i = 0; i<n+1; i++){
            t[i][0] = true;
        }
            for(int j = 1; j<sum+1; j++){
                t[0][j] = false; 
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
                if(arr[i-1] > j){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j-arr[i-1]]|| t[i-1][j];
                }
            }
        }
        ArrayList<Integer> val = new ArrayList<>();
        for(int i = 0; i<=sum/2; i++){
            if(t[n][i] == true){
                val.add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<val.size(); i++){
            min  =  Math.min(min, sum-2*val.get(i));
        }
        return min;
    }
}