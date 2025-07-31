public class FindPositive{
    public static void main(String[] args){

        int[] arr = {1,2,3,4};
        int k = 2;

        FindPositive kk = new FindPositive();
        int res = kk.findKthPositive(arr,k);
        System.out.println(res);
    }
    
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int missing = arr[mid] - (mid+1);  // Kitne No. Missing Hai jis position pr hai unn tk

            if(missing < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left + k;
    }
}