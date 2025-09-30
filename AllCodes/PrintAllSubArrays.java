import java.util.*;

public class PrintAllSubArrays{
    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5};

        System.out.println(Arrays.toString(arr));

       for(int i = 0; i<arr.length; i++){
        for(int j = i; j<arr.length; j++){
            for(int k = i; k<=j; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
       }
       System.out.println(subarrayExist(9, arr));
       System.out.println(subarrayExist2(22, arr));
       System.out.println(firstsubArray(arr, 16));
       System.out.println(longestSubarray(new int[]{2,4,6,8,4}, 12));
    }
    public static boolean subarrayExist(int k , int[] arr){
        HashMap<Integer , Integer> gg = new HashMap<>();
        gg.put(0,1);

        int sum = 0;
        
        for(int i : arr){
            sum += i;
     // Check if (sum - k) exists in the map
            if(gg.containsKey(sum - k)){
                return true;
            }
            gg.put(sum,gg.getOrDefault(sum, 0)+1);
        }
        return false;
    }

    public static boolean subarrayExist2(int k, int[] arr){
        HashSet<Integer> gg = new HashSet<>();
        gg.add(0); // Initialize with sum 0

        int sum = 0;
        for(int i : arr){
            sum += i;

            if(gg.contains(sum-k)){
                return true;
            }
            gg.add(sum);
        }
        return false;
    }

    // When We Want longest subarrays we don't update index to the curr index in map while vice versa for smallest

    public static ArrayList<Integer> firstsubArray(int[] arr , int k){
        ArrayList<Integer> gg = new ArrayList<>();
        gg.add(-1);

        HashMap<Integer,Integer> kk = new HashMap<>();
        kk.put(0,-1);

        int sum = 0;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];

            int rem = sum - k;
            if(kk.containsKey(rem)){
                int start = kk.get(rem)+1;
                gg.set(0,start);
                gg.add(i);
                return gg;
            }
            if(!kk.containsKey(sum)){
                kk.put(sum,i);
            }
        }
        return gg;
    }

    public static int longestSubarray(int[] arr, int k) {
       
        int max = 0;
        
        HashMap<Integer,Integer> gg = new HashMap<>();
        gg.put(0,-1);
        
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            
            int rem = sum - k;
            if(gg.containsKey(rem)){
                int len = i - gg.get(rem);
                max = Math.max(len,max);
            }
            if(!gg.containsKey(sum)){
                gg.put(sum,i);
            }
        }
        return max;
     }

     
}