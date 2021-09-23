import java.util.Arrays;

public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i;
            for(i=nums.length-1;i>=1;i--){
                if(nums[i]>nums[i-1])
                    break;  //找到最右端的升序序列
            }
            if(i==0)
                reverse(nums);
            else{
                int min = Integer.MAX_VALUE;
                int index = 0;
                for(int j = i; j<nums.length;j++){
                    if(nums[j] < min && nums[j] > nums[i-1]) {  //找到nums[i-1]右端找到一个比它大的最小值
                        min = nums[j];
                        index = j;
                    }
                }
                swap(nums,i-1,index);
                Arrays.sort(nums,i,nums.length);
            }
        }

        public void reverse(int[] nums){
            for(int i = 0, j = nums.length-1; i<j; i++,j--)
                swap(nums,i,j);
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
