package DP;
class SubsetSum{
    public static void main(String[] args){
        int arr[] = {2,3,7,1,10};
        int sum = 11;
        int n = arr.length;

        System.out.println(isSubset(arr, n, sum));
        System.out.println(isSubsetRecursive(arr, n, sum));
        
        System.out.println(totalSubset(arr, sum, n));

        // Memoization left

    }

    public static boolean isSubset(int[] arr, int n , int sum){ // Bootom up approach
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<sum+1; j++){
                if(i==0){
                    t[i][j] = false;  // no. of element 0 hai or sum > 0 koi option nahi hai  
                }
                if(j == 0){
                    t[i][j] = true; // sum 0 ho or kitne bhi element le lo empty subset to hai
                }
            }
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
        return t[n][sum];
    }

    public static boolean isSubsetRecursive(int[] arr, int n , int sum){

        if(sum == 0) return true; // sum pahle aaya if wo mil jaye n khatam hone se pahle
        if(n == 0) return false;

        if(arr[n-1] > sum){
            return isSubsetRecursive(arr, n-1, sum);
        }

        return isSubsetRecursive(arr, n-1, sum) || isSubsetRecursive(arr, n-1, sum-arr[n-1]);
    }

    public static int totalSubset(int[]arr , int target , int n){
        int[][] t = new int[n+1][target+1];

        for(int i = 0; i<n+1; i++){
             // if(i == 0) t[i][j] = 0;
            t[i][0] = 1;  // koi bhi row ho col. zero then 1 
        }
            for(int j = 1; j<target+1; j++){
                // if(j == 0) t[i][j] = 1;
                t[0][j] = 0;  // koi bhi col. ho lekin row 0 h to 0
            }
        
        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<target+1; j++){

                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][target];
    }
}