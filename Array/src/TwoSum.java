/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/two-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class  TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] index = new int[2];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    index[0] = map.get(target - nums[i]);
                    index[1] = i;
                    break;
                }
                map.put(nums[i], i);
            }
            return index;
        }
    }
}
