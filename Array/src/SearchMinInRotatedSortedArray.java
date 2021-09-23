public class SearchMinInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            int min = Integer.MAX_VALUE;
            while(left <= right){
                int mid = (left+right)/2;
                if(nums[mid] < nums[right]){  //右半边有序
                    min = Math.min(min,nums[mid]);
                    right = mid-1;  //查找左半边
                }
                else{  //左半边有序
                    min = Math.min(min,nums[left]);
                    left = mid+1;
                }
            }
            return min;
        }
    }
}
