public class QuickSort {
    public void quickSort(int[] nums){
       recursiveSort(nums,0,nums.length-1);
    }
    private void recursiveSort(int[] nums, int left, int right){
        if(left<right){
            int p = partition(nums, left, right);
            recursiveSort(nums, left, p-1);
            recursiveSort(nums, p+1,right);
        }
    }

    private int partition(int[] nums, int left, int right){
        int p = (int)(Math.random() * 10) %(right-left+1) + left;
        swap(nums, left, p);
        int pivot = nums[left];
        int i = left+1;
        int j = left;

        while(i <= right){
            if(nums[i] < pivot){
                swap(nums,i,++j);
            }
            i++;
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
