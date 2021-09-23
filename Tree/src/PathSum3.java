public class PathSum3 {
    class Solution {
        int res = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root==null)
                return 0;
            getSum(root,sum);  //从根节点开始走
            pathSum(root.left,sum);  //从各个节点开始走
            pathSum(root.right,sum);

            return res;
        }

        public void getSum(TreeNode root, int sum){
            if(root == null) return;
            sum-=root.val;
            if(sum==0)
                res++;
            getSum(root.left,sum);
            getSum(root.right,sum);
        }
    }
}
