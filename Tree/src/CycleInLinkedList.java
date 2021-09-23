public class CycleInLinkedList {
    class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;
            while(fast !=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast)  //有环，则快慢指针一定会相遇
                {
                    hasCycle = true;
                    break;
                }
            }
            if(!hasCycle)
                return null;
            slow = head;
            //之后关键来了：相遇后，一个指针指向head，另一个不变。速度均改为1，继续移动、相遇。相遇点即是入环点。
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
