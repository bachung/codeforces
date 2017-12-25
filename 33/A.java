import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int loser = 0;

        boolean answer = true;
        boolean[] playing = new boolean[] {true, true, false};
        for (int i = 0; i < n; i++) {
            int win = scan.nextInt() - 1;
            boolean foundLoser = false;
            if (!playing[win]) {
                answer = false;
                break;
            }
            for (int j = 0; j < 3; j++) {
                if (j != win && playing[j]) {
                    loser = j;
                    playing[j] = false;
                    foundLoser = true;
                    break;
                }
            }
            if (!foundLoser) {
                answer = false;
                break;
            }
            for (int j = 0; j < 3; j++) {
                if (!playing[j] && j != loser) {
                    playing[j] = true;
                }
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}