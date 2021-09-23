import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrderTraverse(root,list);

            int min = Integer.MAX_VALUE;
            for(int i=0;i<list.size()-1;i++){
                min = Math.min(min, Math.abs(list.get(i)-list.get(i+1)));
            }
            return min;
        }

        public void inOrderTraverse(TreeNode node,List<Integer> list){
            if(node!=null){
                inOrderTraverse(node.left,list);
                list.add(node.val);
                inOrderTraverse(node.right,list);
            }
        }
    }
}
