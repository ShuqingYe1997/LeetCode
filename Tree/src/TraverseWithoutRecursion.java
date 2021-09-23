import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseWithoutRecursion {
    public List<Integer> inOrderTraverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            // 找到最左的节点
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    public List<Integer> preOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
          while(root != null){
              list.add(root.val);
              stack.push(root);
              root = root.left;
          }
          root = stack.pop();
          root = root.right;
        }
        return list;
    }

    public List<Integer> postOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        TreeNode pre = null;  //记录上一个被访问的节点
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            //没有右子树或者右子树已经被访问，就可以愉快的访问根节点了
            if(root.right == null || root.right == pre){
                list.add(root.val);
                pre = root;
                root = null;
                stack.pop();
            }
            else
                root = root.right;
        }
        return list;
    }
}
