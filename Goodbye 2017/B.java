import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();

        char[][] maze = new char[n][m];

        for (int i = 0; i < n; i++) {
            maze[i] = scan.next().toCharArray();
        }

        char[] directions = scan.next().toCharArray();
        int res = 0;

        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 'S') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        int[] mapping = new int[] {0, 1, 2, 3};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if (i == j || i == k || i == l) continue;
                        if (j == k || j == l) continue;
                        if (k == l) continue;
                        mapping[0] = i;
                        mapping[1] = j;
                        mapping[2] = k;
                        mapping[3] = l;
                        if (runDirections(maze, r, c, directions, mapping)) {
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    static boolean runDirections(char[][] grid, int r, int c, char[] dirs, int[] mapping) {
        for (char cur : dirs) {
            int num = mapping[(int)(cur - '0')];
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
                return false;
            }
            if (grid[r][c] == '#') {
                return false;
            }
            if (grid[r][c] == 'E') {
                return true;
            }
            if (num == 0) {
                r += 1;
            } else if (num == 1) {
                r -= 1;
            } else if (num == 2) {
                c += 1;
            } else if (num == 3) {
                c -= 1;
            }
        }
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] == '#') {
            return false;
        }
        if (grid[r][c] == 'E') {
            return true;
        }
        return false;
    }
}