public class IncreasingTripletSubsequence {
    class Solution {

        //Your algorithm should run in O(n) time complexity and O(1) space complexity.
        public boolean increasingTriplet(int[] nums) {
            if( nums == null || nums.length < 3)
                return false;
            int min = Math.min(nums[0], nums[1]);
            int mid = Math.max(nums[0], nums[1]);
            for(int i = 2; i<nums.length;i++){
                if(nums[i] > mid)
                    return true;
                else if(nums[i] < mid && nums[i] > min)
                    mid = nums[i];
                else if(nums[i] < min){
                    min = nums[i];
                }
            }
            return false;
        }
    }
}
