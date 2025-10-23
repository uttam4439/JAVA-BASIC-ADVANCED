import java.util.ArrayList;

class NoOneMoreThanZero{
    public static void main(String[] args){
        ArrayList<String> gg = new ArrayList<>();
        int n = 3;
        solver(n, n, n, "", gg);

        System.out.println(gg);

    }

    public static void solver(int n , int ones , int zero , String output , ArrayList<String> gg){
        if(n == 0){
            gg.add(output);
            return;
        }
        solver(n-1,ones+1,zero,output+"1",gg);

        if(ones > zero){
            solver(n-1, ones, zero+1, output+"0", gg);
        }
    }
}