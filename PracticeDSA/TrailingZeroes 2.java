import java.util.*;

public class TrailingZeroes{
    public static void main(String[] args){

        // System.out.println("Enter The Number");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int count = 0;

        while(n >= 5){
            n = n/5;
            count = count + n;
        }
        System.out.println(count);
    }
}