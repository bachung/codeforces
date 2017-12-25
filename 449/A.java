import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();
        
        char[] s = scan.next().toCharArray();

        for (int i = 0; i < m; i++) {
            int l, r;
            l = scan.nextInt() - 1;
            r = scan.nextInt() - 1;

            char c = scan.next().charAt(0);
            char c2 = scan.next().charAt(0);

            for (int j = l; j <= r; j++) {
                if (s[j] == c) {
                    s[j] = c2;
                }
            }
        }
        System.out.println(new String(s));
    }
}