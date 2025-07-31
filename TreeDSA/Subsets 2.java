import java.util.*;
public class Subsets{
    public static void main(String[] args){
        
    }

    public static void createSubsets(int i, int n, List<Integer> x){
        if(i > n){
            System.out.println(x);
            return;
        }

        // Include i
        x.add(i);
        createSubsets(i+1, n, x);
    }
}