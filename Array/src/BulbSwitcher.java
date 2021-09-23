import java.util.Arrays;

public class BulbSwitcher {
    class Solution {
        public int bulbSwitch(int n) {
            if(n==0 || n==1)
                return n;
            int a = (int)Math.sqrt(n);
            int[] power = new int[a+1];
            for (int i = 1; i <= a; i++) {
                power[i] = i*i;
            }
            return binarySearch(power,1,a,n);
        }
        private int binarySearch(int[] nums, int left, int right, int target){
            if(left < right){
                int mid = (right - left)/2 + left;
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] > target)
                    right = mid;
                else
                    left = mid+1;
                return binarySearch(nums,left,right,target);
            }
            return left;
        }
    }
}
