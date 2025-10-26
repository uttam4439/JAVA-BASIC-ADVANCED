import java.util.*;
class Josephusproblem{
    public static void main(String[] args){

        ArrayList<Integer> gg = new ArrayList<>(40);
        int n = 40;
        int k = 7;

        for(int i = 1; i<=n; i++){
            gg.add(i);
        }
        int ans = survived(gg, 0, k-1);

        System.out.println(ans);

    }

    public static int survived(ArrayList<Integer> gg , int index , int k){
        if(gg.size() == 1){
            return gg.get(0);
            
        }

        index = (index + k) % gg.size();
        gg.remove(index);

        return survived(gg, index, k);
    }
}
