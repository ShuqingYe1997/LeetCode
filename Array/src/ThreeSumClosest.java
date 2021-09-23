import java.util.Arrays;

public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = Integer.MIN_VALUE;
            for(int i=0;i<nums.length-2;i++){
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if(Math.abs(sum-target) < Math.abs(result-target))
                        result = sum;  //此时的更接近
                    if(sum < target)
                        left++;
                    else if(sum > target)
                        right--;
                    else
                        return target;  //都相等了，就直接返回了
                }
            }
            return result;
        }
    }
}
