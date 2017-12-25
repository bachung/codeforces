import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();

        int[] friends = new int[n];
        for (int i = 0; i < n; i++) {
            friends[i] = flipBit(friends[i], i);
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            a = scan.nextInt() - 1;
            b = scan.nextInt() - 1;
            friends[a] = flipBit(friends[a], b);
            friends[b] = flipBit(friends[b], a);
        }
        ans = new int[1 << n];
        Arrays.fill(ans, -1);
        next = new int[1 << n];
        Arrays.fill(next, -1);
        System.out.println(solve(0, friends));

        List<String> order = new ArrayList<>();
        int cur = 0;
        while (next[cur] != -1) {
            order.add("" + (next[cur] + 1));
            cur = flipBit(cur, next[cur]);
        }
        System.out.println(String.join(" ", order));
    }

    static boolean getBit(int num, int a) {
        return (num & (1 << a)) > 0;
    }

    static int flipBit(int num, int a) {
        return (num ^ (1 << a));
    }

    static int fullFriends = 0;

    static int[] next;
    static int[] ans;
    // static int[] oldFriends;;        
    static int iter = 0;

    static int solve(int used, int[] friends) {
        if (ans[used] >= 0) return ans[used];
        boolean done = true;
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] != (1 << friends.length) - 1) {
                done = false;
                break;
            }
        }
        if (done) {
            ans[used] = 0;
            return 0;
        }
        // iter++;
        // if (iter % 1000 == 0) System.out.println(iter);
        // System.out.println(iter++);
        // System.out.println(fullFriends);

        int min = Integer.MAX_VALUE / 2;
        int[] oldFriends = new int[25];
        for (int j = 0; j < friends.length; j++) {
            oldFriends[j] = friends[j];
        }
        for (int i = 0; i < friends.length; i++) {
            if (!getBit(used, i)) {
                
                for (int j = 0; j < friends.length; j++) {
                    if (getBit(friends[i], j)) {
                        friends[j] = friends[j] | friends[i];
                    }
                }

                int tent = 1 + solve(flipBit(used, i), friends);
                
                for (int j = 0; j < friends.length; j++) {
                    friends[j] = oldFriends[j];
                }

                if (tent < min) {
                    min = tent;
                    next[used] = i;
                }
            }
        }
        ans[used] = min;
        return min;
    }
}