import java.util.*;
import java.math.BigDecimal;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a, b;
        char c;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.next().charAt(0);

        BigDecimal A, B;
        A = BigDecimal.valueOf(a);
        B = BigDecimal.valueOf(b);
        A.setScale(9999);
        B.setScale(9999);

        BigDecimal C = A.divide(B, 9999, BigDecimal.ROUND_HALF_UP);
        // System.out.println("FINSIHED DIVIDE");
        String CS = C.toString() + "0.0";

        int d = -1;
        boolean found = false;
        for (int i = 0; i < CS.length() - 4; i++) {
            if (d == -1 && CS.charAt(i) == '.') {
                d = 0;
            } else if (d >= 0) {
                d++;
                if (CS.charAt(i) == c) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println(d);
        } else {
            System.out.println(-1);
        }
    }
}