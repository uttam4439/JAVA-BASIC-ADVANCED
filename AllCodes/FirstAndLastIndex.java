import java.util.*;
public class FirstAndLastIndex{
    public static void main(String[] args){

        int[] arr = {1,2,2,2,2,5,6,9,11};
        int x = 2;

        FirstAndLastIndex kk = new FirstAndLastIndex();
        kk.find(arr,x);
    }

     ArrayList<Integer> find(int[] arr, int x) {
        int first = FirstIndex(arr,x);
        int last = LastIndex(arr,x);
        
        ArrayList<Integer> gg = new ArrayList<>();
        gg.add(first);
        gg.add(last);
        System.out.println(gg);
        return gg;
     }

        public int FirstIndex(int arr[], int x){
        int left = 0;
        int right = arr.length-1;
        int LowerBound = -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(arr[mid] == x){
                LowerBound = mid;
                right = mid - 1;
            }else if(arr[mid] < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return LowerBound;
    }
    
        public int LastIndex(int arr[], int x){
        int left = 0;
        int right = arr.length-1;
        int UpperBound = -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(arr[mid] == x){
                UpperBound = mid;
                left = mid + 1;
            }else if(arr[mid] < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return UpperBound;
    }
        
    }

