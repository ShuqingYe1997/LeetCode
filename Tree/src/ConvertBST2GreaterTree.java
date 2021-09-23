public class ConvertBST2GreaterTree {


    class Solution {
        public int sum ;
        public TreeNode convertBST(TreeNode root) {
            if(root==null)
                return root;
            rightRecursive(root);
            return root;
        }

        private void rightRecursive(TreeNode parent){
            if(parent!=null){
                rightRecursive(parent.right);
                parent.val += sum;  //这个sum用的太灵性了
                sum = parent.val;
                rightRecursive(parent.left);
            }
        }

    }
}
