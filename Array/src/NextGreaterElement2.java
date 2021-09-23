import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement2 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if(nums.length == 0)
                return new int[0];
            Stack<Integer> stack = new Stack<>();  // 存index
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length * 2; i++) {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                    res[stack.pop()] = nums[i % nums.length];
                }
                if(i < nums.length)
                    stack.push(i);
            }
            while(!stack.isEmpty()) {
                res[stack.pop()] = -1;
            }
            return res;
        }
    }
}
