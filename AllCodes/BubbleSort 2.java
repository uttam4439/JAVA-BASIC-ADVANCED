import java.util.*;

public class BubbleSort{

    public static void main(String[] args){

        System.out.println("Enter the size of arr");
        Scanner gg = new Scanner(System.in);
        int[] arr = new int[gg.nextInt()];

        for(int i = 0; i<arr.length; i++){
            arr[i] = gg.nextInt();
        }
        BubbleSort.call(arr);
    }
    public static void call(int[] arr){
        int[] ans = BubbleSort.sort(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] sort(int[] arr){
        for(int i = 0; i <arr.length-1; i++){
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    
}