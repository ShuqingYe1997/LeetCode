
import java.util.LinkedList;
import java.util.Queue;

public class HouseRobber3 {
    class Solution {
        public int rob(TreeNode root) {
                if(root == null)
                    return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum1 = 0;
            int sum2 = 0;
            int label = 1;
            while(!queue.isEmpty()){
                int n = queue.size();
                while(n-- > 0){
                    TreeNode top = queue.poll();
                    if(label == 1){
                        sum1 += top.val;
                        if(top.left!=null)
                            queue.add(top.left);
                        if(top.right!=null)
                            queue.add(top.right);
                    }
                    else{
                        sum2 += top.val;
                        if(top.left!=null)
                            queue.add(top.left);
                        if(top.right!=null)
                            queue.add(top.right);
                    }
                }
                if(label == 1)label=2;
                else label =1;
            }
            return Math.max(sum1,sum2);
        }

    }
}
