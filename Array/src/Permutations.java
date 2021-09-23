import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //经典回溯
    class Solution {
        public List<List<Integer>> result;
        public int[] nums;
        public boolean[] visited;
        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            visited = new boolean[nums.length];
            result = new ArrayList<>();
            backtrace(new ArrayList<>());
            return result;
        }

        public void backtrace(List<Integer> list){
            if(list.size()==nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            else{
                for(int i=0;i<nums.length;i++){
                    if(!visited[i]){
                        list.add(nums[i]);
                        visited[i] = true;
                        backtrace(list);

                        visited[i] = false;
                        list.remove(list.size()-1);
                    }
                }
            }
        }
    }
}
