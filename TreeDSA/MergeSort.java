import java.util.ArrayList;
import java.util.Arrays;

class MergeSort{
    public static void main(String[] args) {
        int arr[] = {2,9,3,1,7,5};
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr , int start ,int end){
        if(start < end){
            int mid = start + (end - start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            mergeArr(arr,start,mid,end);
        }
    }

    public static void mergeArr(int[] arr, int start , int mid , int end){
        java.util.ArrayList<Integer> temp = new ArrayList<>();

        int i = start; 
        int j = mid+1;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[i]);
                i++;
        }
        while(j <= end){
            temp.add(arr[j]);
            j++;
        }

        for(int x = 0; x<temp.size(); x++){
            arr[x+start] = temp.get(x);
        }
    }
}