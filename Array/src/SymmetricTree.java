public class SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root,root);
        }

        //两棵树是否镜像
        public boolean isMirror(TreeNode root1, TreeNode root2){
            if(root1==null && root2==null)
                return true;
            else if(root1!=null && root2==null || root2!=null &&root1==null)
                return false;
            else{
                if(root1.val == root2.val)
                    return (isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left));
            }
            return false;
        }
    }

}

