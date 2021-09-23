import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
//            int[] sortedNums = Arrays.copyOfRange(nums,0,n);
//            Arrays.sort(sortedNums);
//            int[][] dp = new int[n][n];
//            int maxLen = -1;
//
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    if(nums[i] == sortedNums[j]){
//                        dp[i][j] = dp[i-1][j-1]+1;
//                        maxLen = Math.max(maxLen, dp[i][j]);
//                    }
//                    else
//                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
//                }
//            }
//            return maxLen;
//        }
//    }
            int maxLen = -1;
            int max = Integer.MIN_VALUE;
            int start = 0;
            int i = start;
            while(i < n){
                if(nums[i] > max) //strictly more than
                {
                    max = nums[i];
                    maxLen = Math.max(maxLen,i-start+1);
                    i++;
                }
                else {
                    start = i;
                    max = nums[i];
                    i++;
                }
            }
            return maxLen;
        }

    }
}
