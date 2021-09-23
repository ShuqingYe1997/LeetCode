import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RussianDoll {
    class Solution {

        //这个想法太好了
        //长从小到大，若长一样则宽由大到小，在宽中找最大递增子序列的个数
        public int maxEnvelopes(int[][] nums) {
            int n = nums.length;
            if (n == 0 || n == 1)
                return n;
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0])
                        return o1[0] - o2[0];
                    else return o2[1] - o1[1];  //大的宽排在前
                }
            });
            int[] dp = new int[n];
            int res = 0;
            for(int i = 0; i<n;i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j][1] < nums[i][1])
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res,dp[i]);
            }
            return res+1;
        }
    }
}
