public class FindPeakElement {
    class Solution {

        //Your solution should be in logarithmic complexity.
        public int findPeakElement(int[] nums) {
            if(nums==null || nums.length==0 || nums.length==1)
                return 0;

            return binaryFindPeak(nums,0,nums.length-1);

        }

        public int binaryFindPeak(int[] nums, int left, int right){
            if(right-left+1>2){  //长度大于2
                int mid = (right-left)/2+left;
                if(nums[mid] > nums[mid+1] && nums[mid]>nums[mid-1])
                    return mid;
                if(nums[mid] > nums[mid-1] && nums[mid] <nums[mid+1])
                    return binaryFindPeak(nums,mid+1, right);  //查找大的一半
                else return binaryFindPeak(nums, left, mid);
            }
            else if(right-left+1==2){  //长度等于2
                return nums[right]>nums[left]?right:left;
            }
            else return left;
        }
    }
}
