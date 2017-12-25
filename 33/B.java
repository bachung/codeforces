import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        int lastNum = -1;
        int k = 1;
        int greatest = -1;
        while (lastNum <= num) {
            int abc = (int)(Math.pow(2, k) - 1) * (int)(Math.pow(2, k - 1));
            if (num % abc == 0) greatest = abc;
            lastNum = abc;
            k++;
        }
        System.out.println(greatest);
    }
}