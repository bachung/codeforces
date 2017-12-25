import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int h1, a1, c1, h2, a2;
        h1 = scan.nextInt();
        a1 = scan.nextInt();
        c1 = scan.nextInt();
        h2 = scan.nextInt();
        a2 = scan.nextInt();

        solve(h1, a1, c1, h2, a2);
    }

    static void solve(int h1, int a1, int c1, int h2, int a2) {
        boolean turn = true;
        int phases = 0;
        List<String> lines = new ArrayList<>();
        while (h2 > 0) {
            if (turn) {
                phases++;
                if (h2 <= a1) {
                    h2 -= a1;
                    lines.add("STRIKE");
                } else if (h1 <= a2) {
                    h1 += c1;
                    lines.add("HEAL");
                } else {
                    h2 -= a1;
                    lines.add("STRIKE");
                }
            } else {
                h1 -= a2;
            }
            // System.out.println(h2);
            turn = !turn;
        }
        System.out.println(phases);
        System.out.println(String.join("\n", lines));
    }
    
}