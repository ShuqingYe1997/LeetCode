import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            if(root == null)
                return null;
            q.add(root);
            bfs(q, new ArrayList<>(), res , true);
            return res;
        }

        public void bfs(Queue<TreeNode> q, List<Integer> list, List<List<Integer>> res, boolean left2right){
                int n = q.size();
                if(n == 0)return;
                List<TreeNode> nodes = new ArrayList<>();
                while(n-- > 0) {
                    TreeNode top = q.peek();
                    list.add(top.val);  //记录数值的
                    nodes.add(top);  //记录节点的
                    q.remove();
                }
                res.add(list);

                for(int i = nodes.size()-1;i>=0;i--){
                    TreeNode node = nodes.get(i);
                    if (left2right) {
                        if (node.left != null)
                            q.add(node.left);
                        if (node.right != null)
                            q.add(node.right);
                    } else {
                        if (node.right != null)
                            q.add(node.right);
                        if (node.left != null)
                            q.add(node.left);
                    }
                }
                left2right = !left2right;
                bfs(q,new ArrayList<>(), res,left2right);
            }
        }
}
