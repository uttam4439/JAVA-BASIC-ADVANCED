import java.util.*;

public class LowerBound{
    public static void main(String[] args){
        int[] nums = {2,4,6,5,3,7,11,9,8,1,2,2,2};
        int target = 2;
        Arrays.sort(nums);

        /*smallest index in the sorted array where the element 
        is greater than or equal to the given number.*/

        //Finding LowerBound for 2 
        int left = 0;
        int right = nums.length-1;
        int lowerBound = -1;

        
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                lowerBound = mid;
                right = mid - 1;
            }if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
         if(lowerBound != -1){
            System.out.println("Lower bound of " + target +" "+ "is " + lowerBound);
        }else{
            System.out.println("LowerBound is Not Found");
        }


    }
    
}