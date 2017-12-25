import java.util.*;

public class C {

    static long[] lengths = new long[100001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        calcLens();
        long asd = 0;
        // while (true) {
        //     asd += 1000000000000000L;
        //     System.out.println(asd);
        //     getCharacter2(56, asd);
        //     if (false) break;
        // }
        // // System.out.println();

        //test
        for (int i = 0; i < q; i++) {
            int n = scan.nextInt();
            long k = scan.nextLong();
            System.out.print(getCharacter2(n, k - 1));
        }
        System.out.println();
    }

    static void calcLens() {
        lengths[0] = str.length();
        for (int i = 1; i < lengths.length; i++) {
            lengths[i] = first.length() + 2 * lengths[i - 1] + mid.length() + end.length();
            if (lengths[i] < 0) {
                // System.out.println((i - 1) + ": " + lengths[i - 1]);
                // System.out.println("First negative length: " + i);
                for (int j = i + 1; j < lengths.length; j++) {
                    lengths[j] = lengths[i];
                }
                break;
            }
        }
    }
    final static String first = "What are you doing while sending \"";
    final static String mid = "\"? Are you busy? Will you send \"";
    final static String end = "\"?";
    final static String str = "What are you doing at the end of the world? Are you busy? Will you save us?";

    static char getCharacter2(int n, long k) {
        while (n > 0) {
            if (lengths[n] > 0 && k >= lengths[n]) {
                return '.';
            }
            if (k < first.length()) {
                return first.charAt((int)k);
            } else if (k < (long)first.length() + lengths[n - 1] || lengths[n - 1] < 0) {
                n --;
                k -= (long)first.length();
            } else if (k < (long)first.length() + lengths[n - 1] + (long)mid.length()) {
                return mid.charAt((int)(k - first.length() - lengths[n - 1]));
            } else if (k < (long)first.length() + (long)2 * (long)lengths[n - 1] + (long)mid.length()) {
                
                k -= ((long)first.length() + (long)lengths[n - 1] + (long)mid.length());
                n --;
            } else {
                if((k - ((long)first.length() + (long)2 * (long)lengths[n - 1] + (long)mid.length())) < 0) return '.';
                return end.charAt((int)(k - ((long)first.length() + (long)2 * (long)lengths[n - 1] + (long)mid.length())));
            }
        }
        if (k >= str.length()) return '.';
        return str.charAt((int)k);
    }
}