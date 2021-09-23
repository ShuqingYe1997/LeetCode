public class _JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int i = 0;
            int end = nums.length - 1;
            while (i < end) {
                int max = -1;
                for (int j = i + nums[i]; j > i; j--) {
                    if (j >= end) return true;
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }
                if (max == -1) return false;
                i = max;
            }
            return true;
        }
    }
}
//
// [1,1,2,2,0,1,1]
// [1,1,1,0]
// [2,3,1,1,4]
// [3,2,1,0,4]}
