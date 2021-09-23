public class MaximumPathSum {
    class Solution {
        int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            return recursion(root);
        }

        public int recursion(TreeNode root){
            if(root == null)
                return 0;
            else{
                int left = Math.max(recursion(root.left),0);
                int right = Math.max(recursion(root.right),0);
                res = Math.max(res,left+right+root.val);
                return Math.max(left,right)+root.val;  //返回当前的路径值
            }
        }
    }
}
