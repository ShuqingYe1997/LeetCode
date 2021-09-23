public class FindFirstAndLastPosition {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1,-1};
            if(nums == null || nums.length == 0)
                return result;
            int left = 0;
            int right = nums.length-1;

            //left margin
            while(left < right){
                int mid = left+(right-left)/2;
                if(nums[mid]>=target) right = mid;
                else left = mid+1;
            }
            if(nums[left]!=target) return result;
            result[0] = left;

            //right margin
            while(left < right){
                int mid = left+(right-left)/2;
                if(nums[mid]<=target) left = mid+1;
                else right = mid;
            }
            result[1] = left-1;
            return result;
        }
    }
}
