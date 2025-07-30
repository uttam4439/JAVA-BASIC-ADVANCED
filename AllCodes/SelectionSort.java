class SelectionSort{
    public static void main(String args[]){
     int nums[] = {2,1,1,3,5,11,4,7,3};
     for (int i=0; i<nums.length-1; i++){
        int min = i;
        for(int j=i+1; j<nums.length; j++){
            if(nums[j]>nums[min]){
                min = j;
            }
        }
            int temp = nums[min];
            nums[min] =  nums[i];
            nums[i] = temp;
     }
     for (int x: nums){
        System.out.print(x + " ");
     }
}
}