import java.util.*;

public class C {
    static int[] numRecords;
    static int[] maxes;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];
        removeToInc = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        if (nums.length == 2) {
            System.out.println(Math.min(nums[0], nums[1]));
            return;
        } else if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }

        calc2(nums);
        int maxAdded = -999999999;
        int num = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (removeToInc[i] > maxAdded) {
                maxAdded = removeToInc[i];
                num = i;
            } else if (removeToInc[i] == maxAdded) {
                if (i < num) {
                    num = i;
                }
            }
        }

        System.out.println(num);
    }

    static void calcNumRecord(int[] nums) {
        int maxSoFar = 0;
        int seen = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] > maxSoFar) {
                seen++;
                numRecords[i] = seen;
            }
            maxSoFar = Math.max(maxSoFar, nums[i]);
            maxes[i] = maxSoFar;
        }
    }

    static int[] removeToInc;

    static void calc2(int[] nums) {
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> b - a);
        Q.add(nums[0]);
        Q.add(nums[1]);
        removeToInc[nums[0]]--;
        if (nums[1] > nums[0]) {
            removeToInc[nums[1]]--;
        } else {
            removeToInc[nums[0]]++;
        }
        for (int i = 2; i < nums.length; i++) {
            int max = Q.poll();
            int secondMax = Q.peek();
            Q.add(max);
            if (nums[i] > max) {
                removeToInc[nums[i]]--;
            }
            if (nums[i] < max && nums[i] > secondMax) {
                removeToInc[max]++;
            }
            Q.add(nums[i]);
        }
    }
}