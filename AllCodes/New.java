class New{
    public static void main(String args[]){
        int nums[] = {2,1,1,3,5,11,4,7,3};
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums.length-i; j++){ // nums.length-i means which index(i) is done should be not take next time.
                if(nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        for(int x : nums){
            System.out.println(x);
        }
    }
}