import java.io.*;
public class Recursion{
    public static void main(String[] args) throws IOException{
        Recursion kk = new Recursion(); 
        int n = 5;
        BufferedReader gg = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(gg.readLine());
        Recursion.Ntimes(0,x); //Static access direct through class name if method is static;
        /* while(true){
            System.out.println(n);
        } */

        // Stack Overflow Error ----- kk.Try(n);
        System.out.println();
        kk.Try2(n);   //Creating Object is for Non - static method; 
        System.out.println();
        Recursion.OnetoN(1,x);

        System.out.println();
        Recursion.NtoOne(x, 1);

        System.out.println();
        Recursion.NtoOne(x);

        System.out.println();
        Recursion.BackTracking(x, x);

        System.out.println();
        Recursion.reverseBackTracking(1, x);



    }

    /*   static void Try(int n){
         System.out.print(n);
         Try(n);
    } */

    static int count = 0;
    void Try2(int n){ 
        if(count == 4){
            return;
        }
        System.out.print(count);
        count++;
        Try2(n);
    }

    static void Ntimes(int i, int x) throws IOException{
        if(i > x){
            return;
        }
        System.out.print(x);
        Ntimes(i+1, x);
    }

    static void OnetoN(int i, int x){
        if(i>x){
            return;
        }
        System.out.print(i);
        OnetoN(i+1,x);
    }

    static void NtoOne(int x, int i){
        if(x < i){
            return;
        }
        System.out.print(x);
        NtoOne(x-1,i);
    }

    static void NtoOne(int i){
        if(i < 1){
            return;
        }
        System.out.print(i);
        NtoOne(i-1);
    }

    static void BackTracking(int i , int x){
        if(i < 1){
            return;
        }
        BackTracking(i-1, x);
        System.out.print(i);
    }

    static void reverseBackTracking(int i, int x){
        if(i > x){
            return;
        }
        reverseBackTracking(i+1, x);
        System.out.print(i);
    }
}