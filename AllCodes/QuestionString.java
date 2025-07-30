import java.util.Arrays;

class QuestionString{
    public static void main(String args[]){
        // Prefix Sum

        int[] arr = {123,12,23,4,5,6,45,67};
        int[] newarr = new int[arr.length];
        int target = 23;
        newarr[0] = arr[0];

        for(int i = 1; i<arr.length; i++){
            newarr[i] = newarr[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(newarr));
        System.out.println(Position(arr, target));
    }

    static int Position(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    int[] nums = {4,5,5,6,6,6,6,6,7}; // I am taking Sorted Array 
    int z = 6;
    int left = 0;
    int right = nums.length-1;
     int FirstandLast(int[] nums, int z){
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == z){
                return mid;
            }
        }


        

        return -1;
    }

}