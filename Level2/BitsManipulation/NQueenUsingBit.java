import java.util.Scanner;

public class NQueenUsingBit {

    public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
        if (row == board.length) {
            System.out.println(asf + ".");
            return;
        }
        // if cols contain that column that column then its not safe
        // if ndiag (i,j) contains (i+j) then its not safe
        // if rdiag (i,len-1-j)
        for (int i = 0; i < board.length; i++) {
            if (
                (cols & (1 << i)) == 0 && 
                (ndiag & (1 << (row + i))) == 0 && 
                (rdiag & (1 << (row - i + board.length - 1))) == 0
                ) {
                board[row][i] = true;
                cols ^= (1 << i);
                ndiag ^= (1 << (row + i));
                rdiag ^= (1 << (row - i + board.length - 1));
                solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + i + ", ");
                ndiag ^= (1 << (row + i));
                rdiag ^= (1 << (row - i + board.length - 1));
                cols ^= (1 << i);
                board[row][i] = false;

            }

        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        int cols = 0;
        int ndiag = 0;
        int rdiag = 0;
        scn.close();
        solution(board, 0, cols, ndiag, rdiag, "");
    }
}
