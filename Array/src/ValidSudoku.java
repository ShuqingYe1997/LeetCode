public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] grid = new boolean[9][9];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (!row[i][num] && !col[j][num] && !grid[i/3*3+j/3][num]) {  //逐级压缩
                            row[i][num] = true;
                            col[j][num] = true;
                            grid[i/3*3+j][num] = true;

                        } else
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
