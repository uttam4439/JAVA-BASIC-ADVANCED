class InsertionSort{
    public static void main(String args[]){
        int nums[]= {2,4,3,11,9,8,7};
        for (int i=0; i<=nums.length-1; i++){ // nums[i] is a value present at i-th position while i is just a position
            int j = i;
            while (j>0 && nums[j-1] > nums[j]){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        for (int x : nums){
            System.out.println(x);
        }
    }
}