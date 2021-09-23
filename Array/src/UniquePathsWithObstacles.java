public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            if(m<=0) return 0;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            int i,j;
            for(i=0;i<m;i++){
                if(obstacleGrid[i][0]==1)
                    break;
                dp[i][0] = 1;
            }
            for(int k=i;k<m;k++)
                dp[k][0] = 0;
            for(j=0;j<n;j++){
                if(obstacleGrid[0][j]==1)
                    break;
                dp[0][j] = 1;
            }
            for(int k=j;k<n;k++)
                dp[0][j] = 0;

            for(i = 1;i<m;i++){
                for(j = 1;j<n;j++){
                    if(obstacleGrid[i][j]==1)
                        dp[i][j]=0;
                    else {
                        if (obstacleGrid[i - 1][j] == 1)
                            dp[i - 1][j] = 0;
                        if (obstacleGrid[i][j - 1] == 1)
                            dp[i][j - 1] = 0;
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
