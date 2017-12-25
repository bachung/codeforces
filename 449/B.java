import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int p = scan.nextInt();

        long answer = 0;
        int len = 2;
        long num = 11;
        for (int i = 0; i < k; i++) {
            answer += num;
            answer %= p;
            int mid = len / 2;

            boolean found = false;
            for (int j = mid; j < len; j++) {
                if (getDigit(num, j) != 9) {
                    num = incDigit(num, j);
                    num = incDigit(num, len - j - 1);
                    for (int k1 = len - j; k1 < j; k1++) {
                        num = zeroDigit(num, k1);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                len += 2;
                num = (long)Math.pow(10, len - 1) + 1;
            }
        }
        System.out.println(answer);
    }

    static int getDigit(long num, int n) {
        while (n != 0) {
            num /= 10;
            n--;
        }
        return (int)(num % 10L);
    }

    static long zeroDigit(long num, int i) {
        int dig = getDigit(num, i);
        long add = dig;
        while (i > 0) {
            add *= 10;
            i--;
        }
        return num - add;
    }

    static long incDigit(long num, int i) {
        long add = 1;
        while (i > 0) {
            add *= 10;
            i--;
        }
        return num + add;
    }


}