import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] board = new char[9][9];

        int idx = 0;
        for (int i = 0; i < 11; i++) {
            if (i == 3 || i == 7) {
                scan.nextLine();
                continue;
            }
            board[idx++] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
        String[] lastMove = scan.nextLine().split(" ");
        int row, col;
        row = Integer.parseInt(lastMove[0]) - 1;
        col = Integer.parseInt(lastMove[1]) - 1;
        int nextBoard = 0;
        boolean done = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == col && i == row) {
                    done = true;
                    break;
                } else if (getBoard(i, j) == getBoard(row, col)) {
                    nextBoard++;
                }
            }
            if (done) {
                break;
            }
        }
        // System.out.println(getBoard(row, col) + " NextBoard: " + nextBoard);

        int countInNextBoard = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (getBoard(i, j) == nextBoard && board[i][j] != '.') {
                    countInNextBoard++;
                }
            }
        }
        // System.out.println(countInNextBoard);
        if (countInNextBoard == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        board[i][j] = '!';
                    }
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (getBoard(i, j) == nextBoard && board[i][j] == '.') {
                        board[i][j] = '!';
                    }
                }
            }
        }

        String result[] = new String[9];
        for (int i = 0; i < 9; i++) {
            String s = new String(board[i]);
            s = s.substring(0, 3) + " " + s.substring(3, 6) + " " + s.substring(6, 9);
            result[i] = s;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
        System.out.println("");
        for (int i = 3; i < 6; i++) {
            System.out.println(result[i]);
        }
        System.out.println("");
        for (int i = 6; i < 9; i++) {
            System.out.println(result[i]);
        }

    }

    static int getBoard(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }


}