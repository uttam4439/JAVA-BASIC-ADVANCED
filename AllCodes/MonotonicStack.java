import java.util.*;
public class MonotonicStack{
    public static void main(String[] args){
        int[] arr = {2,1,2,4,3};

        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }

    public static int[] nextGreaterElement(int[] arr){

        int[] res = new int[arr.length];
        Stack<Integer> gg = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            while(!gg.isEmpty() && gg.peek() <= arr[i]){
                gg.pop();
            }
            res[i] = gg.isEmpty() ? -1 : gg.peek();

            gg.push(arr[i]);
        }
        return res;
    }

    
}