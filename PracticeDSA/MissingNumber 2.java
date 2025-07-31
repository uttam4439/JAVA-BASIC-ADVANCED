import java.util.*;

public class MissingNumber{
    public static void main(String[] args){

        // System.out.println("Enter The Number");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        
        long[] x = new long[n-1];


        for(int i = 0; i < x.length; i++){
            x[i] = num.nextLong();
        }
        long z = Arrays.stream(x).sum();
        long y = ((long) n * (n+1))/ 2;
        System.out.println(y-z);

    }
}