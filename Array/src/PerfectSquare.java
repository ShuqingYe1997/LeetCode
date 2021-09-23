public class PerfectSquare {

    //dp
    //既然是求加数的最小个数，也可以看作最小步数，用BFS
    class Solution {
        public int numSquares(int n) {
            int num = (int)Math.sqrt(n);
            int[] weight = new int[num+1];
            for(int i=1;i<=num;i++)
                weight[i] = i*i;
            int[] dp = new int[n+1];  //从dp[n+1][num+1]减下来的,二维的这个处理i<weight[j]时很麻烦

            for(int i = 1;i<=n;i++) {
                //System.out.println("round "+i+": ");
                for (int j = 1; j<=num; j++) {
                    if (i >= weight[j]) {
                        int a = dp[i - weight[j]] + 1;
                        if(dp[i]!=0)
                            dp[i] = Math.min(dp[i], a);
                        else dp[i] =a;
                    }
//                    for (int k = 1; k <= n; k++)
//                        System.out.print(dp[k] + " ");
//                    System.out.println();
                }
            }
            return dp[n];
        }
    }
}
