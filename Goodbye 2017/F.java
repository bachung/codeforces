import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];
        char[] colors = new char[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            colors[i] = scan.next().charAt(0);
        }
        int tot = 0;
        int numG = 0;
        int gpos = -1;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 'G') {
                numG++;
                if (gpos != -1) {

                    tot += minToConnect(nums, colors, gpos, i);
                }
                gpos = i;
            }
        }

        int lastPosR = -1;
        int lastPosB = -1;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 'G') {
                if (lastPosR != -1) {
                    tot += nums[i] - lastPosR;
                }
                if (lastPosB != -1) {
                    tot += nums[i] - lastPosB;
                }
                break;
            } else if (colors[i] == 'R') {
                if (lastPosR != -1) {
                    tot += nums[i] - lastPosR;
                }
                lastPosR = nums[i];
            } else if (colors[i] == 'B') {
                if (lastPosB != -1) {
                    tot += nums[i] - lastPosB;
                }
                lastPosB = nums[i];
            }
            // System.out.println(tot);
        }
        // System.out.println(tot);
        if (numG >= 1) {
            lastPosR = -1;
            lastPosB = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (colors[i] == 'G') {
                    if (lastPosR != -1) {
                        tot += lastPosR - nums[i];
                    }
                    if (lastPosB != -1) {
                        tot += lastPosB - nums[i];
                    }
                    break;
                } else if (colors[i] == 'R') {
                    if (lastPosR != -1) {
                        tot += lastPosR - nums[i];
                    }
                    lastPosR = nums[i];
                } else if (colors[i] == 'B') {
                    if (lastPosB != -1) {
                        tot += lastPosB - nums[i];
                    }
                    lastPosB = nums[i];
                }
                // System.out.println(tot);
            }
        }
        
        System.out.println(tot);
    }

    static int minToConnect(int[] nums, char[] colors, int a, int b) {
        int strat1 = 0;
        int lastPos = nums[a];
        for (int i = a + 1; i < b; i++) {
            if (colors[i] == 'R') {
                strat1 += nums[i] - lastPos;
                lastPos = nums[i];
            }
        }
        strat1 += nums[b] - lastPos;
        lastPos = nums[a];
        for (int i = a + 1; i < b; i++) {
            if (colors[i] == 'B') {
                strat1 += nums[i] - lastPos;
                lastPos = nums[i];
            }
        }
        strat1 += nums[b] - lastPos;

        int strat2 = nums[b] - nums[a];
        int lastPosLeft = nums[a];
        int lastPosRight = nums[b];
        int i = a;
        int j = b;

        while (i <= j) {
            if (nums[i] == lastPosLeft) {
                i++;
                while (colors[i] != 'R' && colors[i] != 'G') {
                    i++;
                }
                if (nums[i] >= lastPosRight) break;
            }

            if (nums[j] == lastPosRight) {
                j--;
                while (colors[j] != 'R' && colors[j] != 'G') {
                    j--;
                }
                if (nums[j] <= lastPosLeft) break;
            }
            if (nums[i] - lastPosLeft <= lastPosRight - nums[j]) {
                strat2 += nums[i] - lastPosLeft;
                lastPosLeft = nums[i];
            } else {
                strat2 += lastPosRight - nums[j];
                lastPosRight = nums[j];
            }
        }

         lastPosLeft = nums[a];
         lastPosRight = nums[b];
         i = a;
         j = b;

        while (i <= j) {
            if (nums[i] == lastPosLeft) {
                i++;
                while (colors[i] != 'B' && colors[i] != 'G') {
                    i++;
                }
                if (nums[i] >= lastPosRight) break;
            }

            if (nums[j] == lastPosRight) {
                j--;
                while (colors[j] != 'B' && colors[j] != 'G') {
                    j--;
                }
                if (nums[j] <= lastPosLeft) break;
            }
            if (nums[i] - lastPosLeft <= lastPosRight - nums[j]) {
                strat2 += nums[i] - lastPosLeft;
                lastPosLeft = nums[i];
            } else {
                strat2 += lastPosRight - nums[j];
                lastPosRight = nums[j];
            }
        }
        // System.out.println(strat1 + " " + strat2);
        return Math.min(strat1, strat2);
    }
}