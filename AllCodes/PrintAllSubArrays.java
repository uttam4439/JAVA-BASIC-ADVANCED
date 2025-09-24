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
       System.out.println(subarrayExist(11, arr));
    }
    public static boolean subarrayExist(int k , int[] arr){
        HashMap<Integer , Integer> gg = new HashMap<>();
        gg.put(0,1);

        int sum = 0;
        
        for(int i : arr){
            sum += i;

            if(gg.containsKey(sum - k)){
                return true;
            }
            gg.put(sum,gg.getOrDefault(sum, 0)+1);
        }
        return false;
    }
}