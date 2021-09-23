public class LongestPalindromeSubseq {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            if(s==null || s.length()==0) return 0;
            int n = s.length();
            int[][] dp = new int[n][n];  //dp[i][j]  stands for s[i...j]
            for(int i=0;i<n;i++)
                dp[i][i] = 1;

            for(int i=0;i<n;i++){
                for(int j=i-1;j>=0;j--){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j] = dp[i-1][j+1]+2; //是回文，所以是加2不是加1哦
                    else
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
                }
            }
            return dp[0][n-1];
        }
    }
}
