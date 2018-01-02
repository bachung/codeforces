import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int min = 1;

        int n, k;
        n = scan.nextInt();
        k = scan.nextInt();

        boolean[] found = new boolean[n + 1];
        boolean[] found2 = new boolean[n + 1];

        int[] nums = new int[n];

        for (int i = 0; i < k; i++) {
            nums[i] = scan.nextInt();
        }
        // System.out.println("scnaned");
        // int[] sorted = new int[n];
        Stack<Integer> stack = new Stack<>();
        // int sortedIdx = 0;
        int idx = 0;
        int maxSoFar = Integer.MIN_VALUE;
        while (idx < k) {
            stack.add(nums[idx]);
            maxSoFar = Math.max(maxSoFar, nums[idx]);
            found[nums[idx]] = true;
            found2[nums[idx]] = true;
            if (stack.peek().equals(new Integer(min))) {
                while (min < found.length && found[min]) {
                    min++;
                }
                int prev = stack.pop() + 1;
                while (!stack.isEmpty() && stack.peek().equals(new Integer(prev))) {
                    stack.pop();
                    prev++;
                }
            }
            idx++;
        }
        int idx2 = k;
            int asd = nums[k - 1] - 1;
            while (asd >= min) {
                // System.out.println("GOING TO MIN");
                while(found2[asd]) {
                    asd--;
                }
                if (asd == 0) break;
                if (asd < min) break;
                nums[idx2] = asd;
                found2[asd] = true;
                idx2++;
            }
        int foundIdx = n;
        for (int i = idx2; i < n; i++) {
            while (found2[foundIdx]) {
                foundIdx--;
            }
            found2[foundIdx] = true;
            nums[i] = foundIdx;
        }
        while (idx < n) {
            stack.add(nums[idx]);
            found[nums[idx]] = true;
            if (stack.peek().equals(new Integer(min))) {
                while (min < found.length && found[min]) {
                    min++;
                }
                int prev = stack.pop() + 1;
                while (!stack.isEmpty() && stack.peek().equals(new Integer(prev))) {
                    stack.pop();
                    prev++;
                }
            }
            idx++;
        }

        // System.out.println(stack.pop() + " " + stack.pop() + " " +stack.pop());
        if (stack.isEmpty()) {
            String[] result = new String[n];
            for (int i = 0 ; i < nums.length; i++) {
                result[i] = nums[i] + "";
            }
            System.out.println(String.join(" ", result));
        } else {
            System.out.println("-1");
        }
    }
}