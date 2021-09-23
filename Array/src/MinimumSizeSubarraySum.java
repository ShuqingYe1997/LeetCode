import java.util.Map;

public class MinimumSizeSubarraySum {

    //同样是双指针法，分别从头尾走会错过最优解
    class Solution0 {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length <= 0) return 0;
            int left = 0;
            int right = nums.length - 1;
            double sum = 0;
            for (int i = 0; i < nums.length; i++)
                sum += nums[i];
            if (sum < s) return 0;

            while (true) {
                if (nums[left] <= nums[right]) {
                    if (sum - nums[left] >= s) {
                        sum -= nums[left];
                        left++;
                    } else
                        break;
                }
                else{
                    if (sum - nums[right] >= s) {
                        sum -= nums[right];
                        right--;
                    } else
                        break;
                }
            }
            return right - left+1;
        }
    }

    //都从start开始走不会错过最优解(?)
    class Solution{
        public int minSubArrayLen(int s, int[] nums){
            if (nums.length <= 0) return 0;
            int left = 0;
            int right = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++)
                sum += nums[i];
            if (sum < s) return 0;

            sum=0;
            int minLen = (1<<31)-1;
            while(right<nums.length && left<=right){
                if(sum+nums[right]<s)
                {
                    right++;
                    sum+=nums[right];
                }
                else{
                    minLen = Math.min(minLen, right-left+1);
                    sum-=nums[left];
                    left++;
                }
            }
            return minLen;
        }
    }
}
