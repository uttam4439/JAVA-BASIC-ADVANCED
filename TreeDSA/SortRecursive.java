import java.util.*;
public class SortRecursive{
    public static void main(String[] args){

        int arr[] = {3,1,5,2,4};
    }
    public static void sort(ArrayList<Integer> arr){
        if(arr.size() <= 1) return; // base case

        //Remove last element.. because a single no. is sorted
        int last = arr.remove(arr.size()-1);

        //sort remaining arr
        sort(arr);

        //insert last element in sorted arr
        insert(arr,last);
    }

    static void insert (ArrayList<Integer> arr , int value){

    }

}