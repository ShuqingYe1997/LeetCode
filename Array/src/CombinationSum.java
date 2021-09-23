import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//经典的回溯算法，学习一个
public class CombinationSum {
    class Solution {
        public List<List<Integer>> result;
        public int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            this.result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            backTrace(target,0,list);

            return this.result;
        }

        public void backTrace(int target, int start, List<Integer> list){
            if(target < 0) return; //failed
            else if(target ==0){
                result.add(new ArrayList<>(list));   //不能直接放list，因为这是个指针
                return;
            }
            else{
                for(int i=start;i<candidates.length;i++){
                    if(target - candidates[i]<0)
                        break;
                    list.add(candidates[i]);
                    backTrace(target-candidates[i],start,list);  //这里要直接放list，因为要的就是指针,而且因为允许重复同一个数字，所以不是start+1
                    //这一步很关键哦！！返回后要把List末尾去掉
                    list.remove(list.size()-1);
                }
            }


        }
    }
}
