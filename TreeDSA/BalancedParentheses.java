import java.util.*;
class BalancedParentheses{
    public static void main(String[] args){
        ArrayList<String> gg = new ArrayList<>();
        StringBuilder output = new StringBuilder(" ");
        int n = 3;
        solver(n,n,output,gg);
        System.out.println(gg);

        ArrayList<String> kk = new ArrayList<>();
        solver(n, n, " ", kk);
        System.out.println(kk);
    }

    public static void solver(int open , int close , StringBuilder output , ArrayList<String> gg){
        if(open == 0 && close == 0){
            gg.add(output.toString());
            return;
        }
        if(open != 0){
            output.append("(");
            solver(open-1,close,output,gg);
            output.deleteCharAt(output.length()-1);
        }
        if(open < close){
            output.append(")");
            solver(open , close-1, output, gg);
            output.deleteCharAt(output.length()-1);
        }
    }

    public static void solver(int open , int close , String output , ArrayList<String> kk){
        if(open == 0 && close == 0){
            kk.add(output);
            return;
        }
        if(open != 0){
            
            solver(open-1,close,output+"(",kk);

        }
        if(open < close){
            
            solver(open , close-1, output+")", kk);

        }
    } 
}