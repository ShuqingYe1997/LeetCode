public class RemoveDuplicates {
    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if(nums.length<=1) return nums.length;

            int cnt = 1;
            int cur = nums[0];
            int i=1;
            int rear = nums.length-1;
            while(i<=rear){
                if(cur != nums[i]){
                    cnt++;
                    cur = nums[i];
                    i++;
                }
                else{
                    for(int j=i;j<rear;j++)
                        nums[j] = nums[j+1];  //用时过多！
                    rear--;
                }
            }
            return cnt;
        }
    }


    //double pointer: unique ... |i| duplicated |j| unvisited...
    //用时1ms，击败了100%的Java用户。。。
    class Solution2 {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) return nums.length;

            int i = 0, j = 1;
            while (j < nums.length) {
                if (nums[i] == nums[j])
                    j++;
                else {
                    nums[++i] = nums[j];
                    j++;
                }
            }
            return i + 1;
        }
    }
}


