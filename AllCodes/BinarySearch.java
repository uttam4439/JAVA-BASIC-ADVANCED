import java.util.*;

public class BinarySearch{
    public static void main(String args[]){
        int[] arr = {21,12,11,17,19,81,90};
        int target = 11;

        int result  = Bsearch(arr, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }

    static int Bsearch(int[] arr , int target){
        Arrays.sort(arr);

        int left  = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2 ;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            right  = mid - 1;
        }else{
            left = mid + 1;
        }
    }
    return -1;

    }
}