import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int k, n;
        k = scan.nextInt();
        n = scan.nextInt();
        String[] s = new String[k];
        for (int i = 0; i < k; i++) {
            s[i] = scan.next();
        }

        String first = s[0];
        int[] same = new int[first.length()];
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i].charAt(j) == first.charAt(j)) {
                    same[j]++;
                }
            }
        }
        int lowest = Integer.MAX_VALUE, c1 = -1, c2 = -1;
        for (int i = 0; i < n; i++) {
            if (same[i] < lowest) {
                lowest = same[i];
                c1 = i;
            }
        }
        // System.out.println(lowest);
        lowest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == c1) continue;
            if (same[i] < lowest) {
                lowest = same[i];
                c2 = i;
            }
        }
        // System.out.println(lowest + " " + c1 + " " + c2);
        // if (lowest > 0) {
        //     System.out.println(-1);
        //     return;
        // }
        char[] c = first.toCharArray();
        char temp = c[c1];
        c[c1] = c[c2];
        c[c2] = temp;
        for (String string : s) {
            if (!poss(c, string)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(new String(c));
    }

    static boolean poss(char[] c, String s) {
        int diff = 0;
        int idx1 = -1;
        int idx2 = -1;
        boolean g1 = false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (c[i] != s.charAt(i)) {
                diff++;
                if (diff == 1) {
                    idx1 = i;
                } else if (diff == 2) {
                    idx2 = i;
                } else {
                    return false;
                }
            }
            counts[(int)(s.charAt(i) - 'a')]++;
            if (counts[(int)(s.charAt(i) - 'a')] > 1) {
                g1 = true;
            }
        }
        return (diff == 2 && (c[idx1] == s.charAt(idx2) && c[idx2] == s.charAt(idx1))) || diff == 0;// || (diff == 0 && g1);
    }
}