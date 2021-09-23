public class BinaryTreeTilt {
    class Solution {
        public int findTilt(TreeNode root) {
            if(root == null)
                return 0;
            return findTilt(root.left)+findTilt(root.right)+Math.abs(getSum(root.left)-getSum(root.right));
        }

        public int getSum(TreeNode root){
            if(root == null) return 0;
            if(root.left == null && root.right == null)
                return root.val;
            else return getSum(root.left)+getSum(root.right);
        }
    }
}
