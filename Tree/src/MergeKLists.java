public class MergeKLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0)
                return null;
            if(lists.length == 1)
                return lists[0];
            return recursion(lists,0,lists.length-1);
        }

        private ListNode recursion(ListNode[] lists, int left, int right){
            if(left<right){
                int mid = (left+right)/2;
                ListNode leftNode = recursion(lists,left,mid);
                ListNode rightNode = recursion(lists,mid+1,right);
                return merge(leftNode,rightNode);
            }
            else if(left == right)
                return lists[left];
            return null;
        }
        
        private ListNode merge(ListNode head1, ListNode head2){
            ListNode head = new ListNode(0);
            ListNode dummy = head;
            while(head1!=null && head2!=null){
                if(head1.val < head2.val) {
                    head.next = head1;
                    head1 = head1.next;
                    head = head.next;
                }
                else{
                    head.next = head2;
                    head2 = head2.next;
                    head = head.next;
                }
            }
            if(head1!=null)
                head.next = head1;
            else
                head.next = head2;
            return dummy.next;
        }
    }
}
