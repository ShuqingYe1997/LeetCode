import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextGreaterElement3 {
    // 下一个排序数
    class Solution {
        public int nextGreaterElement(int n) {
            if (n < 10)
                return -1;
            char[] nums = String.valueOf(n).toCharArray();
            int i = nums.length - 2;
            for(; i >= 0; i--) {  // 右往左，第一个逆序的
                if(nums[i] < nums[i + 1]) {
                    break;
                }
            }
            if (i == 0)
                return -1;
            int j = nums.length - 1;
            for(; j > i; j--) {
                if(nums[j] > nums[i])
                    break;
            }
            swap(nums, i, j);
            Arrays.sort(nums, i + 1, nums.length);
            try{
                return Integer.parseInt(new String(nums));
            }catch (Exception e) {
                return -1;
            }
        }

        public void swap(char[] nums, int i, int j) {
            char tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
