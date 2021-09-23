public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            if(s==null || s.length()==0) return "";
            int n = s.length();
            int[][] dp = new int[n][n];
            String result = "";
            int max = Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                for(int j = i; j>=0;j--){
                    if(s.charAt(i)==s.charAt(j) && (i-j<2 || dp[i-1][j+1]==1))// 这是子串，所以必须连续
                        dp[i][j] = 1;
                    if(dp[i][j] == 1 && max<i-j+1){
                        max=i-j+1;
                        result = s.substring(j,i+1);
                    }
                }
            }
            return result;
        }
    }
}
