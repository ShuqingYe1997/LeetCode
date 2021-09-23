import java.util.*;

public class ContainDuplicate {
    // O(n) = nk，效率实在太低
    class Solution0 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length <= 1) return false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j <= k; j++)
                    if (i + j < nums.length && nums[i] == nums[i + j])
                        return true;
            }
            return false;
        }
    }

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i]))
                    map.put(nums[i], i);
                else {
                    if (map.get(nums[i]) <= k)
                        return true;
                    map.put(nums[i], i);
                }
            }
            return false;
        }
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - t; j <= i + t  && j>=0 && j < nums.length; j++) {
                if ( !map.containsKey(nums[j]))
                    map.put(nums[j], j);
                else {
                    if (map.get(nums[j])-i <= k)
                        return true;
                    map.put(nums[j], j);
                }
            }
        }
        return false;
    }
}
