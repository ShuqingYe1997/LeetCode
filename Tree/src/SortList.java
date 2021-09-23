public class SortList {
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head==null || head.next==null)
                return head;
            return mergeSort(head);
        }

        private ListNode mergeSort(ListNode head){
            if(head.next==null)
                return head;

            ListNode pre = null;  //这个pre很重要呢！别忘记了
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            int c = slow.val;

            pre.next = null;
            ListNode left = mergeSort(head);  //天哪，忘记记住返回的指针值了！
            ListNode right = mergeSort(slow);
            return merge(left,right);  //嘤嘤嘤

        }

        private ListNode merge(ListNode leftHead, ListNode rightHead){
            ListNode head = new ListNode(0);
            ListNode dummyHead = head;
            while(leftHead!=null && rightHead!=null){
                if(leftHead.val < rightHead.val) {
                    head.next = leftHead;
                    leftHead = leftHead.next;
                }
                else {
                    head.next = rightHead;
                    rightHead = rightHead.next;
                }
                head = head.next;
            }
            if(leftHead!=null)
                head.next = leftHead;
            else if(rightHead!=null)
                head.next = rightHead;
            return dummyHead.next;
        }
    }
}
