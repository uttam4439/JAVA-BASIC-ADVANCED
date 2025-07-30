public class NewRecursion{
    
    public static void main(String[] args) {
        NewRecursion.Rec(5);
        System.out.println();
        NewRecursion.occur(5,5);
        System.out.println();
        NewRecursion.occur("Uttam"+" ",5);
        System.out.println();
        System.out.println(NewRecursion.fact(5));

    }

    public static void Rec(int n){ // n to 1
        if(n==1){
            System.out.print(1);
            return;
        }
        Rec(n-1);  
        // Pahle hi call lag gya to uss func pe chala gya tb print hoga
        System.out.print(n);
        
        }

        public static void occur(int x ,int y){
           if(y == 0){
            return;
           }
           occur(x, y-1);
           System.out.print(x);
        }

        public static void occur(String x, int y){
            if(y == 0){ // jb occur times 0 ho jay tb return kro 
                return ;
            }
            occur(x,y-1);   // x hi input hai occur time ek km hua
            System.out.print(x);  // jb sara call khatam tb pahla print
        }

        public static int fact(int n){
            if(n==0 || n == 1){
                return 1;
            }
                return n * fact(n-1);
                
        }
}