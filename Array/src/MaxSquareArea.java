import java.util.Arrays;

public class MaxSquareArea {
    class Solution {

        public int maximalSquare(char[][] matrix) {
            int n = matrix.length;
            if(n==0) return 0;
            int m = matrix[0].length;
            if (m == 0) return 0;

            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (matrix[i - 1][j - 1] == '1')
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    //        dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长
                }
            }
            int max = 0;
            for (int i = 0; i <= n; i++)
                for (int j = 0; j <= m; j++)
                    max = Math.max(max, dp[i][j]);
            return max * max;
        }
    }
}
