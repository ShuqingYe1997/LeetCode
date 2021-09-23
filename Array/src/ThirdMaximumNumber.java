import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ThirdMaximumNumber {

    // 第K个最大值
    class Solution {
        public int thirdMax(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++)
                set.add(nums[i]);
            Integer[] numsUnique = set.toArray(new Integer[set.size()]);

            int res = recursive(numsUnique,0,numsUnique.length-1);
            if(res == Integer.MAX_VALUE)
                return numsUnique[0];
            return res;
        }

        public int recursive(Integer[] nums, int left, int right){
            if(left<=right){
                int mid = partition(nums, left, right);
                if(mid == 2) return nums[mid];
                else if (mid < 2) return recursive(nums, mid+1, right);
                else return recursive(nums, left, mid-1);
            }
            return Integer.MAX_VALUE;
        }

        public int partition(Integer[] nums, int left, int right){
            Random random = new Random();
            int p = random.nextInt(right-left+1) + left;
            swap(nums, p,left);

            int pivot = nums[left];
            int i = left+1;
            int j = left;
            while(i<=right){
                if(nums[i]>pivot)
                    swap(nums,i,++j);
                i++;
            }
            swap(nums, left, j);
            return j;
        }

        public void swap(Integer[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

    }
}
