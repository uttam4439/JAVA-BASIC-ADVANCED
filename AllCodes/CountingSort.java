import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int arr[] = {1,3,2,3,4,1,6,4,3};
        String srr = "ccddadaann";

        cs.call(arr);
        cs.call(srr);
    }
    public void call(int[] arr){
        int[] Sortedarr = Sort(arr);
        System.out.println("Array is Sorted" + Arrays.toString(Sortedarr));
    }
    private static int[] Sort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max+1];

        for(int x = 0; x<arr.length; x++){
            count[arr[x]]++;
        /* arr[x] ka jo value hai usko ++ kro count array m jitni baar 
        mile ,0 h count array m  */ 
        }
        
        for(int x = 1; x<count.length; x++){
            count[x] = count[x-1] + count[x];
        /* count arr m starting postion save krwa rahe hai element ka */     
        }
        int[] ans = new int[arr.length];
        for(int x = arr.length-1;  x >= 0; x--){
            ans[--count[arr[x]]] = arr[x];
        }
        return ans;
    }
    public void call(String srr){
        String s = Sort(srr);
        System.out.println("Counting String Sort" + " " + s);
    }

    private static String Sort(String srr){
        int count[] = new int[26];

        for(char c : srr.toCharArray()){
            count[c- 'a']++; 
            // takes tha ascii value and subtract from a to get index
            // a = 97 so a-a = 0 index
        }
        StringBuilder sorted = new StringBuilder();
        for(int i = 0; i < 26; i++){
        while(count[i]-- > 0){
            sorted.append((char)(i + 'a'));
            // changes back to charater 0 + 97 = a

        }
    }
        return sorted.toString();

    }
}

