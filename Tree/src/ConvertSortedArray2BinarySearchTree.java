public class ConvertSortedArray2BinarySearchTree {
    class Solution {

        // 二叉搜索树，左子树全比根节点小，右子树全比根节点大
        //区间分治
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums == null) return null;
            return build(nums,0,nums.length-1);
        }

        public TreeNode build(int[] nums, int left, int right){
            if(left>right)
                return null;
            int mid = left+(right-left)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = build(nums,left,mid-1);
            node.right = build(nums,mid+1,right);
            return node;
        }
    }
}
