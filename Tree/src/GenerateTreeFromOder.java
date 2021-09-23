public class GenerateTreeFromOder {
    //重点在于画图，并由前序遍历和后序遍历根节点位置的独特特点形成递归

    //从前序遍历和中序遍历重构树
    class Solution1 {
        public TreeNode InAndPre(TreeNode[] pre, TreeNode[] in) {
            if(pre == null || in == null || pre.length != in.length)
                return null;
            return recursiveInAndPre(pre, 0, pre.length - 1,
                                     in, 0, in.length - 1);
        }

        //前序遍历第一个一定是根节点
        private TreeNode recursiveInAndPre(TreeNode[] pre, int preStart, int preEnd,
                                           TreeNode[] in, int inStart, int inEnd) {

            if(preStart > preEnd || inStart > inEnd)
                return null;
            int i;
            for (i = inStart; i <= inEnd; i++)
                if (in[i].val == pre[preStart].val)
                    break;
            TreeNode root = new TreeNode(in[i].val);
            root.left = recursiveInAndPre(pre, preStart + 1, preStart + i - inStart,
                    in, inStart, i - 1);
            root.right = recursiveInAndPre(pre, preStart + i - inStart + 1, preEnd,
                    in, i + 1, inEnd);
            return root;
        }
    }

    //从后序遍历和中序遍历重构树
    class Solution2{
        public TreeNode PostAndIn(TreeNode[] post, TreeNode[] in){
            if(post == null || in == null || post.length != in.length)
                return null;
            return recursivePostAndIn(post, 0 ,post.length-1,
                                        in, 0 , in.length-1);
        }

        //后序遍历的最后一个是根节点
        private TreeNode recursivePostAndIn(TreeNode[] post, int postStart, int postEnd,
                                            TreeNode[] in, int inStart, int inEnd){
            if(postStart > postEnd || inStart > inEnd)
                return null;
            int i;
            for(i = inStart; i<=inEnd ;i++)
                if(in[i] == post[postEnd])
                    break;
            TreeNode root = new TreeNode(in[i].val);
            root.left = recursivePostAndIn(post, postStart, postStart + i - inStart - 1,
                                            in, inStart, i-1);
            root.right = recursivePostAndIn(post, postEnd - inEnd + i, postEnd-1,
                                            in, i+1,inEnd);
            return root;
        }
    }
}
