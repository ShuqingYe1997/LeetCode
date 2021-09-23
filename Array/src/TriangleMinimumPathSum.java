import java.util.Arrays;
import java.util.List;

public class TriangleMinimumPathSum {

    //Each step you may move to adjacent numbers on the row below.
    class Solution0 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            if(n==0) return 0;
            int[][] dp = new int[n][];
            for(int i=0;i<n;i++){
                int m = triangle.get(i).size();
                dp[i] = new int[m];
                for(int j=0;j<m;j++){
                    dp[i][j] = getMin(dp,i-1,j,i-1,j-1,n,m-1)+ triangle.get(i).get(j);
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=0;i<dp[n-1].length;i++)
                if(dp[n-1][i] < min)
                    min = dp[n-1][i];
            return min;
        }

        private int getMin(int[][] dp, int i1, int j1, int i2, int j2, int n, int m){
            boolean a = i1 < n && i1>=0 && j1 < m && j1>=0;
            boolean b =  i2 < n && i2>=0 && j2 < m && j2>=0;
            if(a && b)
                return Math.min(dp[i1][j1], dp[i2][j2]);
            else if(!a && b)
                return dp[i2][j2];
            else if(a && !b)
                return dp[i1][j1];
            else return 0;
        }
    }

    //自底向上！
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            if (n == 0) return 0;
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                    int a = triangle.get(i).get(j);
                    triangle.get(i).set(j, a + min);
                }
            }
            return triangle.get(0).get(0);
        }
    }
}
