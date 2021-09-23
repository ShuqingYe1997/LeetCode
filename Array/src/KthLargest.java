public class KthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return recursiveFind(nums,0,nums.length-1,k);
        }

        public int recursiveFind(int[] nums, int left, int right, int k){
            int p = partition(nums,left,right);
            if(p == k-1)
                return nums[p];
            else if(p > k-1)
                return recursiveFind(nums, left,p-1,k);
            else if (p < k-1)
                return recursiveFind(nums,p+1,right,k);
            else return -1;
        }

        public int partition(int[] nums, int left, int right){
            int i = left + 1;
            int j = left;
            int pivot = nums[left];
            while(i <= right){
                if(nums[i] > pivot)   //大的被甩到前面来，是大根堆
                    swap(nums, i, ++j);
                i++;
            }
            swap(nums,left,j);
            return j;
        }

        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
