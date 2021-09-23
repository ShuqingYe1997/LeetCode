import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backTrace(root, result, new ArrayList<>(), target);
            return result;
        }

        public void backTrace(TreeNode node, List<List<Integer>> result, List<Integer> list, int target) {
            if (node == null)
                return;
            target -= node.val;
            list.add(node.val);
            if (target == 0) {
                if (node.left == null && node.right == null)
                    result.add(new ArrayList<>(list));
            }

            //之所以不加else,是因为节点val可以为0
            backTrace(node.left, result, list, target);
            //list.remove(list.size()-1);
            backTrace(node.right, result, list, target);
            list.remove(list.size() - 1);
        }
    }
}
