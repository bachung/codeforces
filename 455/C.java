import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a, b, c;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        int min = Math.min(Math.min(a, b), c);
        int num2 = 0;
        if (a == 2) num2++;
        if (b == 2) num2++;
        if (c == 2) num2++;
        int num3 = 0;
        if (a == 3) num3++;
        if (b == 3) num3++;
        if (c == 3) num3++;
        int num4 = 0;
        if (a == 4) num4++;
        if (b == 4) num4++;
        if (c == 4) num4++;

        if (min > 3) {
            System.out.println("NO");
        } else if (min == 3) {
            if (num3 == 3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else if (min == 2) {
            if (num2 >= 2) {
                System.out.println("YES");
                return;
            }
            if (num4 >= 2) {
                System.out.println("YES");
                return;
            }
            System.out.println("NO");
            
        } else if (min == 1) {
            System.out.println("YES");
        }
    }
}