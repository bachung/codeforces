import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        findPrimes(10000);

        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            solve(scan.nextInt(), scan.nextInt());
        }
    }

    static List<Integer> primes = new ArrayList<>();

    static void findPrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i < max + 1; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j < max + 1; j += i) {
                isPrime[j] = false;
            }
            isPrime[i] = true;
            primes.add(i);
        }
    }

    static long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    static void solve(int x, int y) {
        long ans = 0;
        int[] counts = new int[primes.size() + 1];
        int tot = 0;
        for (int prime : primes) {
            while (x % prime == 0) {
                counts[prime]++;
                tot++;
                x /= prime;
            }
        }
    }
}