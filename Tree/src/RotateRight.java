public class RotateRight {
    //环形链表
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null || head.next==null)
                return head;
            ListNode pointer = head;
            while(pointer.next!=null)
                pointer=pointer.next;
            pointer.next = head;
            pointer = head;
            for(int i=0;i<k;i++)
                pointer = pointer.next;
            ListNode newHead = pointer.next;
            pointer.next = null;
            return newHead;

        }
    }
}
