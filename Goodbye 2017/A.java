import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] in = scan.nextLine().toCharArray();

        int tot = 0;
        for (char c : in) {
            if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9'
            || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                tot++;
            } else {

            }
        }

        System.out.println(tot);
    }
}