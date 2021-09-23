import java.util.Arrays;

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            int[] dp = Arrays.copyOf(nums,nums.length);
            for(int i = 0;i<n;i++){
                for(int j = i-2 ; j >=0; j--){
                   dp[i] = Math.max(dp[j]+nums[i], dp[i]);
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<dp.length;i++)
                max = Math.max(dp[i],max);
            return max;
        }
    }
}
