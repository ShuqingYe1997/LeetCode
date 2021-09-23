import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    class Solution {
        //异或的巧妙运用
        //0^n = n
        //n^n = 0
        public int singleNumber(int[] nums) {
            int single = 0;
            for(int i=0;i<nums.length;i++)
                single^=nums[i];
            return single;
        }
    }
}
