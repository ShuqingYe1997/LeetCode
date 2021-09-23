import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveElementsSequence {

//    Input: [100, 4, 200, 1, 3, 2]
//    Output: 4
//    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//    Your algorithm should run in O(n) complexity.
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            // key: num, value: isVisited
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],0);
            }

            int maxLen = 0;
            for(int i = 0;i<nums.length;i++){
                if(map.containsKey(nums[i])) {
                    map.remove(nums[i]);
                    int left = nums[i] - 1;
                    int right = nums[i] + 1;
                    while (map.containsKey(left)) {
                        map.remove(left);
                        left--;
                    }
                    while (map.containsKey(right)) {
                        map.remove(right);
                        right++;
                    }
                    maxLen = Math.max(maxLen,right-left-1);
                }
            }
            return maxLen;
        }
    }
}
