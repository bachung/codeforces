import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a, b, c, d;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();

        int carA = 2 * a, carB = 2 * b, carC = 2 * d;

        for (int i = 1; i < carB; i++) {
            carC = i;
            if (carC < carB && carB < carA && c <= carC && d <= carC && 2 * c >= carC && 2 * d >= carC && 2 * d < carB && 2 * d < carA) {
                System.out.println(carA);
                System.out.println(carB);
                System.out.println(carC);
                return;
            }
        }
        System.out.println("-1");
    }
}