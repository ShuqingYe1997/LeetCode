public class SearchInRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            while(left < right){
                int mid = (left+right)/2;
                if(nums[mid] == target)
                    return mid;
                if(nums[mid] < nums[right]){  //有序的部分是右半边
                    if(nums[mid] < target && target<=nums[right])
                        left = mid+1; //保留右半边
                    else
                        right = mid-1;  //保留左半边
                }
                else { //有序的部分是左半边
                    if(nums[left] <= target && target<nums[mid])
                        right = mid-1;
                    else
                        left = mid+1;
                }
            }
            return -1;
        }
    }
}
