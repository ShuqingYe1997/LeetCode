public class PalindromeList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;

            ListNode slow = head;
            ListNode fast = head;
            //快慢指针，找到中点，学习一个
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondHalf = reverseList(slow.next);  //翻转后半截
            while (secondHalf != null) {
                if (head.val == secondHalf.val) {
                    head = head.next;
                    secondHalf = secondHalf.next;
                } else return false;
            }
            return true;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) return head;
            ListNode cur = head.next;
            head.next = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            }
            return head;
        }
    }
}
