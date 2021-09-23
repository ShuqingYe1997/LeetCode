public class CousinsInBinaryTree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class Solution {
        //父节点不同且在同一层

        int parent_x;
        int parent_y;
        int height_x = 0;
        int height_y = 0;

        public boolean isCousins(TreeNode root, int x, int y) {
            search_x(root,x,0,0);
            search_y(root,y,0,0);
            return (parent_x != parent_y && height_x==height_y);

        }
        public void search_x(TreeNode node, int target,int parent, int height){
            if(node==null)
                return;
            if(node.val == target){
                height_x = height;
                parent_x = parent;
            }
            else{
                parent = node.val;  //这个parent形参一定要有，不然直接放parent_x进去，不是x的父节点也会改掉这个值的！
                //height++;  //找到错误了！不是这个节点所在子树也会把height加上去
                search_x(node.left,target,parent,height+1);
                search_x(node.right,target,parent,height+1);
            }
        }
        public void search_y(TreeNode node, int target, int parent, int height){
            if(node==null)
                return;
            if(node.val == target){
                height_y = height;
                parent_y = parent;
            }
            else{
                parent = node.val;
                //height++;  //找到错误了！不是这个节点所在子树也会把height加上去
                search_y(node.left,target,parent, height+1);
                search_y(node.right,target,parent, height+1);
            }
        }

/*        public void search_x(TreeNode node, int target, int height){
            if(node==null)
                return;
            if(node.val == target)
                height_x = height;
            else{
                parent_x = node.val;  //又搞错了！不是这个节点的parent也会被放进去！
                //height++;  //找到错误了！不是这个节点所在子树也会把height加上去
                search_x(node.left,target,height+1);
                search_x(node.right,target,height+1);
            }
        }
        public void search_y(TreeNode node, int target, int height){
            if(node==null)
                return;
            if(node.val == target)
                height_y = height;
            else{
                parent_y = node.val;
                //height++;  //找到错误了！不是这个节点所在子树也会把height加上去
                search_y(node.left,target,height+1);
                search_y(node.right,target,height+1);
            }
        }*/
    }
}
