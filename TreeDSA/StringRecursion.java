import java.util.*;

public class StringRecursion{
    
    public static void main(String[] args){
        String input = "abc";  
        List<String> gg = new ArrayList<>();
        letterCasePermutation(input, " ", gg);
        System.out.println(gg);

        String in = "a1B2";
        List<String> kk = new ArrayList<>();
        permutationWithDigit(in, " ", kk);
        System.out.println(kk);
    }

    public static void letterCasePermutation(String input , String output , List<String> gg){
        if(input.length() == 0){
            gg.add(output);
            return;
        }
        char ch = input.charAt(0);
        String rem = input.substring(1);
        
        letterCasePermutation(rem, output+ch, gg);
        letterCasePermutation(rem, output+Character.toUpperCase(ch) , gg);
    }

    public static void permutationWithDigit(String in, String out, List<String> kk){
        if(in.length() == 0){
            kk.add(out);
            return;
        }
        char ch = in.charAt(0);
        String rem = in.substring(1);

        if(Character.isAlphabetic(ch)){

            permutationWithDigit(rem, out+Character.toLowerCase(ch), kk);
            permutationWithDigit(rem, out+Character.toUpperCase(ch), kk);
        }else{

            permutationWithDigit(rem, out+ch, kk);
        }
    }

    public static void allCombinations(char[] arr, int index , ArrayList<String> oo){
        // given string change it into char array
    }

}