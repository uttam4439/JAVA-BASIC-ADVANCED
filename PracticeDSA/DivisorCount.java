import java.util.Scanner;

public class DivisorCount {
    public static void main(String[] args) {
        final int MAX = 1000001;
        int[] divisors = new int[MAX];

        // Precompute divisor counts using modified Sieve
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                divisors[j]++;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            output.append(divisors[x]).append("\n");
        }

        System.out.print(output);
        scanner.close();
    }
}
