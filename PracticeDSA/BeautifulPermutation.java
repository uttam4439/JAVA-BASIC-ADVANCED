import java.util.*;

public class BeautifulPermutation{
    public static void main(String[] args){

        // System.out.println("Enter The Number");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();

        if(n == 1){
            System.out.println(1);
        }
        else if(n == 2 || n == 3){
            System.out.println("NO SOLUTION");
        }

        StringBuilder gg = new StringBuilder();

        if(n>= 4){ 
        for(int i = 2; i<=n; i+=2){
            gg.append(i).append(" ");
        }
        for(int i = 1; i<=n; i+=2){
            gg.append(i).append(" ");
        }
    }
        System.out.print(gg);
    }
}