import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        Arrays.sort(nums);
        int count = n;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a, b;
                a = Math.abs(nums[i]);
                b = nums[j];

                if (a < b) {
                    count--;
                    nums[j] = -nums[j];
                    break;
                }
            }
        }
        System.out.println(count);
    }
}