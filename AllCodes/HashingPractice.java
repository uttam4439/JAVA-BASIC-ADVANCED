import java.util.*;

public class HashingPractice{
    public static void main(String[] args){
        Scanner gg = new Scanner(System.in);
        int n = gg.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = gg.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

}