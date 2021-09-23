import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if(nums1.length == 0 || nums2.length == 0)
                return new int[0];
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int i = 0;
            stack.push(nums2[i++]);
            for (; i < nums2.length; i++) {
                if(nums2[i] > stack.peek()) {
                    while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                        map.put(stack.pop(), nums2[i]);
                    }
                    stack.push(nums2[i]);
                }
                else {
                    stack.push(nums2[i]);
                }
            }
            while(!stack.isEmpty()) {
                map.put(stack.pop(), -1);
            }
            int[] res = new int[nums1.length];
            for (int j = 0; j < nums1.length; j++)
                res[j] = map.get(nums1[j]);
            return res;
        }
    }
}
