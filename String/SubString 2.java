package String;

public class SubString{
    public static void main(String[] args){

        String s = "abcbbabcde";   // longest sunstring with unique character
        int maxlen = 0;

        StringBuilder gg = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char z = s.charAt(i);

/*   gg एक StringBuilder है जिसमें हम वर्तमान substring (जिसमें कोई repeated character नहीं है) बना रहे हैं।
gg.indexOf(String.valueOf(z))
→ यह देखता है कि क्या अभी वाला character (z) current में पहले से मौजूद है।
→ अगर हाँ, तो वो उसकी पहली position (index) देता है।
→ अगर नहीं है, तो -1 देता है।

if (index != -1)
→ इसका मतलब है कि character पहले से मौजूद है, यानी repetition हो गया है।

gg.delete(0, index + 1)
→ इसका मतलब है:
→ gg से 0 से लेकर index + 1 तक के सारे characters को हटा दो
→ यानी repeated character और उससे पहले के सभी characters को हटा दो
→ ताकि substring फिर से unique बन जाए।   */
            int idx = gg.indexOf(String.valueOf(z));
            if(idx != -1){
                gg.delete(0,idx+1);
            }
            gg.append(z);
            maxlen = Math.max(maxlen , gg.length());
        }
        System.out.println(maxlen);

    }
}