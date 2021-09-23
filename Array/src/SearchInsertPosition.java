public class SearchInsertPosition {
    class Solution{
        public int searchInsert(int[] nums, int target){
            int left = 0;
            int right = nums.length-1;
            while(left<right){
                int mid = (left+right)/2;
                if(nums[mid]<target)
                    left = mid;
                else if(nums[mid]>target)
                    right=mid;
                else
                    return mid;
            }
            return left;
        }
    }
}
