import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subsets {

    //遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
    //来自 |set| = 2^n 的思想
    class Solution0 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for(int i=0;i<nums.length;i++){
                int n = result.size();
                for(int j = 0; j < n; j++){
                    List<Integer> list = result.get(j);
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            return result;
        }
    }

    //回溯
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrace(result,new ArrayList<>(),nums,0,nums.length-1);
            result.add(new ArrayList<>());  //加个空集
            return result;
        }

        public void backtrace(List<List<Integer>> result,List<Integer> list, int[] nums, int start, int end){
            if(start>end)return;

            for(int i = start;i<=end;i++){
                list.add(nums[i]);
                result.add(new ArrayList<>(list));
                backtrace(result,list,nums,i+1,end);
                list.remove(list.size()-1);
            }
        }
    }
}
