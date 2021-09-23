public class MergeSortedList {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode head = new ListNode(0);
            dummyHead = head;
            recursiveMerge(head,l1,l2);
            return dummyHead.next;
        }

        private void recursiveMerge(ListNode head, ListNode l1, ListNode l2){
            if (l1 == null){
                head.next = l2;
                return;
            }
            if (l2 == null){
                head.next = l1;
                return;
            }
            if(l1.val < l2.val){
                head.next = new ListNode(l1.val);
                head = head.next;
                recursiveMerge(head, l1.next,l2);
            }
            else if(l1.val > l2.val){
                head.next = new ListNode(l2.val);
                head = head.next;
                recursiveMerge(head,l1,l2.next);
            }
            else{
                head.next = new ListNode(l1.val);
                head = head.next;
                head.next = new ListNode(l2.val);
                head = head.next;
                recursiveMerge(head,l1.next,l2.next);
            }
        }
    }
}
