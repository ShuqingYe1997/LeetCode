import java.util.*;

public class AverageOfLevels {
    class Solution {

        //用队列实现如何
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> res = new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int n = queue.size();
                int tmp = n;
                double sum = 0.0;
                while(n>0){
                    TreeNode node= queue.remove();
                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                    sum+=node.val;
                    n--;
                }
                res.add(sum/tmp);
            }
            return res;
        }
    }
}
