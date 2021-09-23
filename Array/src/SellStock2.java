public class SellStock2 {
    class Solution {
        public int maxProfit(int[] nums) {
            if(nums == null || nums.length==0 || nums.length==1)
                return 0;
            int buy = Integer.MAX_VALUE;
            int profit = 0;
            for(int i = 0; i<nums.length;i++){
                if(nums[i] < buy)
                    buy = nums[i];
                else{
                    profit += nums[i] - buy;
                    buy = nums[i];
                }
            }
            return profit;
        }
    }
}
