import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();

        Node[] nodes = new Node[n];

        for (int i = 0 ; i < n; i++) {
            nodes[i] = new Node(scan.nextLong());
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            a = scan.nextInt() - 1;
            b = scan.nextInt() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        long totCost = 0;
        for (Node nn : nodes) {
            if (nn.visited) continue;
            totCost += dfs(nn);
        }
        System.out.println(totCost);
        
    }

    static long dfs(Node start) {
        if (start.visited) return Long.MAX_VALUE;
        start.visited = true;
        long min = start.cost;
        for (Node n : start.adj) {
            min = Math.min(dfs(n), min);
        }
        // System.out.println("Min: " + min);
        return min;
    }

    static class Node {
        List<Node> adj = new ArrayList<>();
        long cost;
        boolean visited = false;

        Node(long cost) {
            this.cost = cost;
        }
    }
}