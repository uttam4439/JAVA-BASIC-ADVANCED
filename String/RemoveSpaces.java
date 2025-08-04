package String;
import java.util.*;

public class RemoveSpaces {
    public static void main(String[] args) {
        
        String sentence = "Hello this im first code using string";
        System.out.println(RemoveSpaces.Uppercase(sentence));

        String s = "abcdefghij";
        char fill = 'x';
        System.out.println(Arrays.toString(split(s, 3, fill)));

        String g = "123";
        int n = Integer.parseInt(g);
        System.out.println(n);

        String str = "Hello#Move#From#Word#to#Front#";
        FrontHash(str);
        
    }

    public static String Uppercase(String sentence){
        StringBuilder gg = new StringBuilder();
        String[] words = sentence.trim().split("\\s+"); // more than one space (\\s+)

        for(int i = 0; i< words.length; i++){
            String w = words[i]; 
 
            gg.append(w.toUpperCase() + " ");
            }
            return gg.toString();
        }

        public static String[] split(String s,int k, char fill){
            int sub = (s.length() + k -1) / k;
            String[] w = new String[sub];

            for(int i = 0; i < sub; i++){
                int start = i * k;
                int end = Math.min(start + k, s.length());
                String chunk = s.substring(start, end);

                if(chunk.length() < k){
                    StringBuilder sb = new StringBuilder(chunk);
                    while(sb.length() < k){
                        sb.append(fill);
                    }
                    chunk = sb.toString();
                }
                w[i] = chunk;

            }
            return w;
        }
        
        /*int curr = 0;
        int max = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j = i+1; j<s.length(); j++){
                char x = s.charAt(j);

                if(c != x){
                    curr++;
                    max = Math.max(curr,max);
                }
            }
        }
        return max; */

        public static void FrontHash(String str){
            char[] c = str.toCharArray();

            int k = c.length-1;

            for(int i = k; i>=0; i--){
                if(c[i] != '#'){
                    char temp = c[i];
                    c[i]=c[k];
                    c[k] = temp;
                    k--;
                }
            }
            System.out.println(String.valueOf(c));
        }
    }

