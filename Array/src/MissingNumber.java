import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class MissingNumber {

    //关键在于额外空间只能是O(1)的，时间还得是0(n)的

    //求和是个很简单有效的好方法
    class Solution0 {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum_real = n*(n+1)/2;
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=nums[i];
            return sum_real-sum;
        }
    }

    //还有个好方法就是异或，相同的数字会被抵消
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum=0;
            for(int i=0;i<n;i++) {
               sum^=i;
               sum^=nums[i];
            }
            return sum;
         }
    }

}
