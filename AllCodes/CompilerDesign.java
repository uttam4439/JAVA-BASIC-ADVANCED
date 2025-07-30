import java.util.*;
public class CompilerDesign{
    // check the comment;
    public static void main(String args[]){

        Scanner gg = new Scanner(System.in);
        String x = gg.nextLine();
        System.out.println(x);
        
        if(x.startsWith("//")){
            System.out.println("This is a single line comment");
        }else if(x.startsWith("/*") && x.endsWith("*/")){
            System.out.println("This is multiline comment");
        }else {
            System.out.println("Just a String");
        }
        gg.close();
    }
}