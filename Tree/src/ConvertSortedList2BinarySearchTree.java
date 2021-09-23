public class ConvertSortedList2BinarySearchTree {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;

            //只有单个元素的情况需单独处理
            if(head.next==null) return new TreeNode(head.val);

            ListNode slow = head,fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode pre = head;
            while(pre.next!=slow)
                pre = pre.next;
            pre.next = null;  //截成两截： head->pre, slow->fast

            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);

            return root;
        }

    }
}
