import java.util.*;


//排好序后，O(n)从n^3 降到 n^2
public class ThreeSums {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i==0 || ( i>0 && nums[i] != nums[i - 1]) ){
                    int a = nums[i] * -1;
                    int j = i + 1;
                    int k = nums.length - 1;
                    while (j < k) {
                        if (nums[j] + nums[k] == a) {
                            list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            while (j < k && nums[j] == nums[j + 1]) j++;  //skip repeated numbers
                            while (j < k && nums[k] == nums[k - 1]) k--;
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] < a) {
                            while (j < k && nums[j] == nums[j + 1]) j++;  //skip repeated numbers
                            j++;
                        } else {
                            while (j < k && nums[k] == nums[k - 1]) k--;
                            k--;
                        }
                    }
                }
            }
            return list;
        }
    }
}
