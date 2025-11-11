import java.util.ArrayList;
import java.util.Arrays;
//O(n * log n) Best
class MergeSort{
    public static void main(String[] args) {
        int arr[] = {2,9,3,1,7,5};
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

        int nums[] = {2,9,3,11,1,7,5};
        quickSortPartion(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    //O(log n)
    public static void mergeSort(int[] arr , int start ,int end){
        if(start < end){
            int mid = start + (end - start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            mergeArr(arr,start,mid,end);
        }
    }
    //O(n)
    public static void mergeArr(int[] arr, int start , int mid , int end){
        //java.util.ArrayList<Integer> temp = new ArrayList<>();
        int[] temp = new int[end-start+1];

        int i = start; 
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                //temp.add(arr[i]);
                temp[k++] = arr[i];
                i++;
            }else{
                //temp.add(arr[j]);
                temp[k++] = arr[j];
                j++;
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        for(int x = 0; x<temp.length; x++){
            arr[x+start] = temp[x];
        }
    }


    public static void quickSortPartion(int nums[] , int st , int ed){
        if(st < ed){
            int pivotIndex = partitionindex(nums,st,ed);

            quickSortPartion(nums, st, pivotIndex-1); // left half
            quickSortPartion(nums, pivotIndex+1, ed); // right half

        }
    }

    public static int partitionindex(int nums[] , int st , int ed){
        int idx = st-1;
        int piv = nums[ed];

        for(int j = st; j<ed; j++){
            if(nums[j] <= piv){
                idx++;

                int temp = nums[j];
                nums[j] = nums[idx];
                nums[idx] = temp;
            }
        }
        int temp = nums[idx+1];
        nums[idx+1] = nums[ed];
        nums[ed] = temp;
        return idx+1;
    }
}