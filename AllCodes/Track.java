import java.util.Arrays;

class Track{
    public static void main(String args[]){
        //countNumber
        int n = 1234569;
        System.out.println(countNumber(n));

        //prefixSum
        int[] arr = {12,13,14,15,14,23,134,245};
        Track gg = new Track();
        gg.prefixSum(arr);

        //factorial
        gg.factorial(5);
        System.out.println(gg.prime(14));

        //replace
        int[] nums = {6,7,18,12,10,8};
        System.out.println(Arrays.toString(gg.replace(nums)));
    }

    static int countNumber(int n){
        int count = 0;
        while(n>0){
            n = n / 10;
            count++;
        }
        return count;
    }

    void prefixSum(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for(int i = 1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];  
            // = arr[i-1] + arr[i] at every index sum changes with previous one from main arr
        } 
        System.out.println(Arrays.toString(prefix));
    }

    void factorial(int x){
        int first = 1;
        for(int i=2; i<=x; i++){
            first = first * i;
        }
        System.out.println(first);
    }

    boolean prime(int x){
        if(x <= 1){
            return false;
        }if(x==2 || x==3){
            return true;
        }if(x % 2 == 0 || x % 3 == 0){
            return false;
        }
        for (int i = 5; i * i <= x; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0)
                return false;
        }
        return true;
    }

     int[] replace(int[] nums){
        int highest = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] > highest){
                highest = nums[i];
            }else{
                nums[i] = highest;
            }
        }
        return nums;
    }
}