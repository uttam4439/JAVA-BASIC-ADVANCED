package String;
import java.util.*;
public class Hello{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int count = 0;

        for(int i = 0; i<a.length; i++){
            a[i] = sc.nextInt();
        }
        int discount = sc.nextInt();
        for(int i = 0; i<a.length; i++){
        if(discount % a[i] == 0){
            count++;
        }
    }
        System.out.print(count);
    }
}