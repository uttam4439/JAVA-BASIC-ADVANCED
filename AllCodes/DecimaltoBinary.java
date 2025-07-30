import java.util.*;

public class DecimaltoBinary{
    public static void main(String[] args){

        DecimaltoBinary kk = new DecimaltoBinary();
        kk.isPower(13);

        int[] arr = {2,3,4};
        System.out.println(kk.Maximum(arr));

        Scanner gg = new Scanner(System.in);
        int n = gg.nextInt();

         while(n>0){
            int x = n%2;
            System.out.print(x);
            n = n/2;
         }
         gg.close();
         
    }

    public boolean isPower(int y) {
        if (y <= 0) {
            System.out.println(false);
        }

        if ((y & (y - 1)) == 0) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    public int Maximum(int[] arr){

        int max  = 0;

        for(int i = 0; i<arr.length; i++){
            for( int j = i+1; j<arr.length; j++){
                int xorValue = arr[i] ^ arr[j];
                max = Math.max(max,xorValue);
            }
        }
        return max;
    }
}