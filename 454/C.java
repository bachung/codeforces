import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        boolean[] cantBe = new boolean[26];
        boolean found = false;
        int excess = 0;
        int letters = 0;        
        for (int i = 0; i < n; i++) {
            String a;
            char[] b;
            a = scan.next();
            b = scan.next().toCharArray();
            char answer = '-';

            if (".".equals(a)) {
                for (char c : b) {
                    if (!cantBe[c - 'a']) {
                        letters++;
                        cantBe[c - 'a'] = true;
                    }
                }
            } else if ("!".equals(a)) {
                if (found) {
                    excess++;
                }
                boolean present[] = new boolean[26];
                for (char c : b) {
                    present[c - 'a'] = true;
                }
                for (int j = 0; j < 26; j++) {
                    if (!present[j]) {
                        if (!cantBe[j]) {
                            letters++;
                            cantBe[j] = true;
                        }
                    }
                }
            } else {
                for (char c : b) {
                    if (!cantBe[c - 'a']) {
                        letters++;
                        cantBe[c - 'a'] = true;
                    }
                }
                if (found && i != n - 1) {
                    excess++;
                }
            }
            // System.out.println("Letters: " + letters);
            if (letters == 25) found = true;
        }
        System.out.println(excess);
    }
}