public class Sentence{
    public static void main(String args[]){

        String gg = "my name is uttam and shubham is roommate";
        int count = 0;

        for(int i = gg.length()-1; i>=0; i--){     //Finding Length of Last Words in Sentence excluding Space ' '
            if(gg.charAt(i) != ' '){
                count++;
            }else if(gg.charAt(i) == ' ' && count != 0){
                break;
            }
        }
        System.out.println(count +" "+ "letter in the Lastword");
    }
}