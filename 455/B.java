import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        int minCakesOnPlate = Integer.MIN_VALUE;

        for (int i = 1; i < Math.min(a, b + 1); i++) {
            int cakeA = b / i;
            int cakeB = c / (a - i);
            if (cakeA == 0 || cakeB == 0) continue;
            minCakesOnPlate = Math.max(minCakesOnPlate, Math.min(cakeA, cakeB));
        }
        System.out.println(minCakesOnPlate);
    }
}