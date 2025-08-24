import java.util.*;

public class StackUsingArray{
    public static void main(String[] args){
       Stack<Integer> gg = new Stack<>();
       gg.push(1);
       gg.push(2);
       gg.push(3);
       gg.push(4);
       gg.push(5);

       System.out.println(gg);
       System.out.println(reverse(gg));
    }

    public static Stack<Integer> reverse(Stack<Integer> gg){
        Stack<Integer> kk = new Stack<>();
        //if(gg.isEmpty()) return gg;

        while(!gg.isEmpty()){
            kk.push(gg.pop());
        }
        return kk;
    }
}