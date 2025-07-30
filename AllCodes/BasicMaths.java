import java.util.*;

class BasicMaths{
    public static int ExtractDigit(int n){
        while(n>0){
            int r = n % 10;
            System.out.println(r);
            n=n/10;
        }
        return n;
    }
    public static int CountDigit(int n){
        int x = 0;
        while(n>0){
            int r = n % 10;
            x++;
            n=n/10;
        }
        return x;
    }

    public static int ReverseNumber(int n){
        int x = 0;
        while(n>0){
            int r = n % 10;
            n=n/10;
            x = (x*10)+r;
        }
        return x;
    }

    public static boolean Palindrome(int n){
        int x = 0;
        int org = n;
        while(n>0){
            int r = n % 10;
            x = (x*10)+r;
            n=n/10;
        }
        return(org == x);

    }

    public static boolean ArmstrongNumber(int n){
        // public static int ArmstrongNumber(int n)
        int sum = 0;
        int org = n;
        int x = String.valueOf(n).length();
        while(n>0){
            int r = n % 10;
            sum += Math.pow(r,x);
            n=n/10;
            
        }
        //return sum;
        return (sum == org);

    }
    public static List<Integer> DivisorFinder(int x){
        Set<Integer> divs = new HashSet<>();

        for(int i=1;i<=Math.sqrt(x);i++){
            if (x%i==0){
                divs.add(i);
                divs.add(x/i);
                }
            }
            List<Integer> sdiv = new ArrayList<>(divs);
            Collections.sort(sdiv);
            return sdiv;
        }

        public static int ExactlyThreeDivisor(int z){
            int count = 0;
            for(int i=1; i<=z; i++){
                if (z%i==0){
                    count++;
                    System.out.println(i);
                }
            }
            // return(count==3) ? "true" : "false";  when returbn type is boolean
            if (count == 3) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
            return count; // Return the count of divisors
        }

        public static boolean FindPrime(int k){
            for (int i=2; i<=Math.sqrt(k); i++){
                if(k%i==0){
                    return false;
                }
            }
            return true;
        }

    public static void main(String args[]){
        int n = 1512898;
        int y = ExtractDigit(n);
        int x = 36;
        System.out.println(CountDigit(n));
        System.out.println(y);
        System.out.println("Reverse No. is " + ReverseNumber(n));
        System.out.println(Palindrome(151));
        System.out.println(ArmstrongNumber(153));
        System.out.println(DivisorFinder(x));
        ExactlyThreeDivisor(9);
        System.out.println(FindPrime(5));
    }
}