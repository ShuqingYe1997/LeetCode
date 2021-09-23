public class MaximumSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int MAX = (1<<31)-1;
            int max_sum=1-MAX;
            int sum=0;
            for (int i =0; i<nums.length;i++){
                sum+=nums[i];
                if(max_sum<sum)
                    max_sum=sum;
                if(sum<0)
                    sum=0;

            }
            return max_sum;
        }
    }
}
