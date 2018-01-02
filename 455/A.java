import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(arr[i], min);
        }

        int idx = Integer.MIN_VALUE / 2;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                if (idx >= 0) {
                    minDist = Math.min(minDist, i - idx);
                    
                }
                idx = i;
            }
        }
        System.out.println(minDist);
    }
}