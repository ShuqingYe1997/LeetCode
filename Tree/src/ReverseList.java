public class ReverseList {
    // iteration
    class Solution0 {
        public ListNode reverseList(ListNode head) {
            if(head==null) return head;
            ListNode cur = head.next;
            head.next=null;
            while(cur!=null){
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            }
            return head;
        }
    }

    // recursion
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            return recursive_reverse(null, head);
        }

        public ListNode recursive_reverse(ListNode pre, ListNode cur){
            if(cur!=null){
                ListNode temp = cur.next;
                cur.next = pre;
                return recursive_reverse(cur,temp);
            }
            return pre;
        }
    }
}
