import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int target) {
            return travel(root,0,target);
        }

        public boolean travel(TreeNode node, int sum, int target){
            if(node == null)
                return false;
            if(node.left == null && node.right == null)
                return sum==target;
            else
                return travel(node.left,sum+node.val,target) || travel(node.right,sum+node.val,target);
        }
    }
}
