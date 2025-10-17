import java.util.*;
public class Subsets{
    public static void main(String[] args){
        StringBuilder inp = new StringBuilder("abc");
        StringBuilder oup = new StringBuilder();

        strSubset(inp, oup);
        System.out.println();
        
        String in = "abc";
        List<String> gg = new ArrayList<>(); 
        strSubset(in, " ", gg);

        System.out.println(gg);

        String src = "axc";
        String tar = "adbhgc";

        System.out.println(isSubsequence(src, tar));
    }

    public static void strSubset(StringBuilder inp , StringBuilder out){
        if(inp.length() == 0){
            System.out.print(out + " ");
            return;
        }
        char ch = inp.charAt(0);

        StringBuilder out1 = new StringBuilder(out);
        StringBuilder out2 = new StringBuilder(out);

        out2.append(ch);

        inp.deleteCharAt(0);

        strSubset(new StringBuilder(inp), out1);
        strSubset(new StringBuilder(inp), out2);
        
    }

    public static void strSubset(String in, String op, List<String> gg){
        if(in.length() == 0){
            gg.add(op);
            return;
        }

        char ch = in.charAt(0);

        String rem = in.substring(1);

        strSubset(rem, op, gg);
        strSubset(rem, op+ch, gg);
    }

    public static boolean isSubsequence(String src , String tar){
        int i = 0;
        int j = 0;

        while(i < src.length() && j < tar.length()){
            if(src.charAt(i) == tar.charAt(j)){
                i++;
            }
            j++;
        }
        return i == src.length();
    }

}

