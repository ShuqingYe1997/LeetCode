public class RemoveElements {

    // 重点在于画出这个小式子： clean...(|i| target...) |j| unvisited...
    class Solution {
        public int removeElement(int[] nums, int val) {
            int i=0,j=0;
            while(j<nums.length){
                if(nums[j]!=val)
                    nums[i++] = nums[j++];

                else
                    j++;
            }
            return i;
        }
    }
}
