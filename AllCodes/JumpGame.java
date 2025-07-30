public class JumpGame {
    public static void main(String args[]){
        int[] capacity = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWater(capacity));

        int[] arr = {0,2,0,1,4};

        int maxJump = 0;
        for(int i=0; i<arr.length; i++){
            if(i>maxJump){  // current index i > maxJump, it means we can't reach this index. So, return false
                System.out.println("false");
                break;
            }
            maxJump = Math.max(maxJump, i+arr[i]); // after check here we start how much i should jump
            if(maxJump>=arr.length-1){
                System.out.println("true");
                break;
            }
        }
    }
        public static int maxWater(int[] capacity){
            
            int left = 0;
            int right = capacity.length-1;
            int maxArea = 0;

            while(left<right){
                int width = right-left;
                int height = Math.min(capacity[left], capacity[right]);
                int area = width*height;
                maxArea = Math.max(maxArea, area);

                if(capacity[left]<capacity[right]){
                    left++;
                }else{
                    right--;
            }
            
        }
        return maxArea;
    }
}