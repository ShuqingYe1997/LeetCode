public class HouseRobber2 {

    //All houses at this place are arranged in a circle.
    class Solution {

        //头尾不能同时拿
        public int rob(int[] nums) {
            if(nums == null || nums.length ==0)
                return 0;
            int n = nums.length;
            int[] dp1 = new int[n];  //去尾
            int max = Integer.MIN_VALUE;
            for(int i = 0; i <n-1;i++){
                if(i==0)
                    dp1[i] = nums[i];
                else if(i == 1)
                    dp1[i] = Math.max(nums[0], nums[i]);
                else
                    dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
                max = Math.max(dp1[i], max);
            }
            int[] dp2 = new int[n];  //掐头
            for(int i = 1; i <n;i++){
                if(i==1)
                    dp2[i] = nums[i];
                else if(i == 2)
                    dp2[i] = Math.max(nums[1], nums[i]);
                else
                    dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
                max = Math.max(dp2[i], max);
            }
            return max;
        }
    }
}
