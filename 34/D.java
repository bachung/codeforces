import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;

        int n = scan.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        long tot = 0;

        for (int i = 0; i < n; i++) {
            long add = (long)(i) * (long)nums[i];

            tot += add - sum;
            int a = nums[i] - 1, b = nums[i], c = nums[i] + 1;
            tot -= nums[i] * map.getOrDefault(a, 0);
            tot += a * map.getOrDefault(a, 0);
            tot -= nums[i] * map.getOrDefault(b, 0);
            tot += b * map.getOrDefault(b, 0);
            tot -= nums[i] * map.getOrDefault(c, 0);
            tot += c * map.getOrDefault(c, 0);
            // System.out.println(tot);
            sum += nums[i];
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            
        }
        System.out.println(tot);
    }
}