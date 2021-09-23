import java.util.List;

public class MergeTwoLists {
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        public ListNode mergeSort(ListNode head) {
            if(head == null || head.next == null)
                return head;
            ListNode pre = head, slow = head, fast = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;  // split the list into two halves
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(slow);
            return merge(left, right);
        }

        private ListNode merge(ListNode h1, ListNode h2) {
            ListNode head = new ListNode(0);
            ListNode dummyHead = head;
            while (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    head.next = h1;
                    h1 = h1.next;
                } else {
                    head.next = h2;
                    h2 = h2.next;
                }
                head = head.next;
            }
            if (h1 == null)
                head.next = h2;
            else
                head.next = h1;
            return dummyHead.next;
        }
    }
}
