public class RangeSumQuery {
    class NumArray {

        int[] nums;
        int[] sums;
        int n;
        public NumArray(int[] nums) {
            if(nums.length>=1){
                this.n = nums.length;
                this.nums = nums;
                this.sums = new int[n];
                sums[0] = nums[0];
                for(int i=1;i<n;i++)
                    sums[i]+=sums[i-1]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return (sums[j] - sums[i]+nums[i]);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
