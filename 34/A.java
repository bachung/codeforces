import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(solve(scan.nextInt()) ? "YES" : "NO");
        }
    }

    static boolean solve(int n) {
        if (n == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        return solve(n - 3) || solve(n - 7);
    }
}