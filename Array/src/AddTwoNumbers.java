public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // level 1
    class Solution0 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode dummy = head;
            int in = 0, sum = 0;
            while (l1 != null && l2 != null) {
                sum = (l1.val + l2.val + in) % 10;
                in = (l1.val + l2.val + in) / 10;
                head.next = new ListNode(sum);
                l1 = l1.next;
                l2 = l2.next;
                head = head.next;
            }
            while (l1 != null) {
                sum = (l1.val + in) % 10;
                in = (l1.val + in) / 10;
                head.next = new ListNode(sum);
                l1 = l1.next;
                head = head.next;
            }
            while (l2 != null) {
                sum = (l2.val + in) % 10;
                in = (l2.val + in) / 10;
                head.next = new ListNode(sum);
                l2 = l2.next;
                head = head.next;
            }
            if (in != 0) {
                head.next = new ListNode(1);
                head = head.next;
            }
            return dummy.next;
        }
    }

    //level 2
    class Solution {
        private int in;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int cnt1 = 0;
            int cnt2 = 0;
            ListNode h1 =  l1;
            ListNode h2 = l2;
            while(h1!=null){
                cnt1++;
                h1=h1.next;
            }
            while (h2!=null){
                cnt2++;
                h2=h2.next;
            }

            for (int i = 0; i < cnt1 - cnt2; i++) {
                    ListNode blank = new ListNode(0);
                    blank.next = l2;
                    l2 = blank;
            }
            for(int i=0;i<cnt2-cnt1;i++) {
                ListNode blank = new ListNode(0);
                blank.next = l1;
                l1 = blank;
            }
            in=0;
            recursiveAdd(l1,l2);

            if(in>=1){
                ListNode node1 = new ListNode(1);
                node1.next = l1;
                l1 = node1;
            }
            return l1;
        }

        //这里的in得是个引用
        public void recursiveAdd(ListNode l1, ListNode l2){
            if(l1.next!=null && l2.next!=null){
                recursiveAdd(l1.next,l2.next);
            }
            int sum = l1.val+l2.val+in;
            l1.val = sum%10;
            in = sum/10;
        }
    }
}
