import java.util.Arrays;

public class ReverseString{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ReverseString rr = new ReverseString();
        rr.call(arr);
        
        String kk = "UTTAM KUMAR";
        char[] gg = kk.toCharArray();

        int left = 0;
        int right = gg.length-1;

        while(left < right){
            char temp = gg[left];
            gg[left] = gg[right];
            gg[right] = temp;
            left++;
            right--;
            
        }
        System.out.println(new String(gg));    
    }
    public void call(int[] arr){
       int nums[] = reverse(arr);
       System.out.println(Arrays.toString(nums));
    }
    private int[] reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int temp = arr[left];
            arr[left++] = arr[right]; // arr[left] = arr[right] then left++;
            arr[right--] = temp; //arr[right] = temp then right++;
        }
        return arr;
    }
}