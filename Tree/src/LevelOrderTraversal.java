import java.util.*;

public class LevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if(root==null) return res;
            ((LinkedList<TreeNode>) queue).add(root);
            while(!queue.isEmpty()){
                int n = queue.size();
                List<Integer> list= new ArrayList<>();
                while(n-- > 0){
                    TreeNode node = queue.remove();
                    list.add(node.val);
                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
                res.add(0,list);
            }
            return res;
        }
    }
}
