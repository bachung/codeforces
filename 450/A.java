import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if (x < 0) {
                l++;
            } else if (x > 0) {
                r++;
            }
            scan.nextInt();
        }
        if (l > 1 && r > 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}