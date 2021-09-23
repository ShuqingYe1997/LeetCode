import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    class Solution {
        List<List<Integer>> result;
        int[] candidates;
        int target;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            this.target = target;
            result = new ArrayList<>();
            backtrace(0,target,new ArrayList<>());

            return result;
        }

        public void backtrace(int index, int target, List<Integer> list){
            if(target==0){
                result.add(new ArrayList<>(list));
                return;
            }
            else if(target<0) return;
            else {
                for(int i = index; i<candidates.length;i++){
                    if(i!=index && candidates[i]==candidates[i-1])  //去重
                        continue;
                    list.add(candidates[i]);
                    backtrace(i+1, target - candidates[i], list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
