import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n, d;
        n = scan.nextInt();
        d = scan.nextInt();

        int[] add = new int[n];
        for (int i = 0; i < n; i++) {
            add[i] = scan.nextInt();
        }

        long[] maxAddedSince = new long[n + 1];
        maxAddedSince[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxAddedSince[i] = Math.max((long)add[i], (long)add[i] + maxAddedSince[i + 1]);
        }

        int count = 0;
        long balance = 0;
        for (int i = 0; i < n; i++) {
            if (add[i] == 0) {
                if (balance < 0) {

                    long maxPossBalance = Math.min(d, d - maxAddedSince[i + 1]);
                    // System.out.println("MAX POSS: " + maxPossBalance);
                    balance = maxPossBalance;
                    if (maxPossBalance < 0) {
                        count = -1;
                        break;
                    }
                    count++;
                }
            } else {
                balance += add[i];
            }
            // System.out.println("Balance is " + balance);
            if (balance > d) {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}