import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        sums = new int[n];
        ans = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        mem = new boolean[1 << n][n];
        solve(nums, 0, 0);
        if (!found) {
            System.out.println(-1);
        } else {
            String[] ansString = new String[n];
            for (int i = 0; i < n; i++) {
                ansString[i] = ""+ans[i];
            }
            System.out.println(String.join(" ", ansString));

        }
    }

    static boolean getBit(int num, int n) {
        return ((num >> n) & 1) == 1;
    }

    static int flipBit(int num, int n) {
        return (num ^ (1 << n));
    }

    static int[] ans;
    static int[] sums;
    static boolean found = false;
    static boolean[][] mem;

    static void solve(int[] nums, int cur, int used) {
        if (cur == nums.length - 1) {
            for (int i = 0; i < nums.length; i++) {
                if (!getBit(used, i)) {
                    ans[cur] = nums[i];
                    break;
                }
            }
            found = true;
            return;
        }
        if (mem[used][cur]) return;
        if (found) return;
        for (int i = 0; i < nums.length; i++) {
            if (getBit(used, i)) continue;
            ans[cur] = nums[i];
            if (sum(ans, cur) != sums[cur]) {
                solve(nums, cur + 1, flipBit(used, i));
            }
            if (found) return;
        }
        mem[used][cur] = true;
    }

    static int sum(int[] nums, int n) {
        int tot = 0;
        for (int i = 0; i <= n; i++) {
            tot += nums[i];
        }
        return tot;
    }
}