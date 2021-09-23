import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
            if (root == null)
                return root;
            if (root.val != n1.val && root.val != n2.val) {
                TreeNode left = lowestCommonAncestor(root.left, n1, n2);  //我原先还用search写这个，真傻，真的
                TreeNode right = lowestCommonAncestor(root.right, n1, n2);
                if (left != null && right != null)
                    return root;
                else if (left != null)
                    return left;
                else if (right != null)
                    return right;
                else return null;
            }
            else return root;  //root.val = n1.val || n2 .val
        }
    }
}
