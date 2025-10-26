package DP;
 
class EqualSumPartition{
    public static void main(String[] args){
        int arr[] = {1,5,11,5,2};
        int n = arr.length;
        System.out.println(equlaSum(arr, n));
    }

    public static boolean equlaSum(int[] arr , int n){
        int x = 0;
        for(int i = 0; i<n; i++){
            x += arr[i];
        }
        if(x % 2 != 0) return false;
        else{
            return SubsetSum.isSubset(arr,n,x/2);
        }
    }


}