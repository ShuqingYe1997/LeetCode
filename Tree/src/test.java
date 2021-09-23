public class test {
    public static void main(String[] argc) {
        ListNode p = new ListNode(1);
        ListNode h1 = p;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(4);

        ListNode q = new ListNode(1);
        ListNode h2 = q;
        q.next = new ListNode(3);
        q = q.next;
        q.next = new ListNode(4);

        MergeSortedList sortList = new MergeSortedList();
        MergeSortedList.Solution solution = sortList.new Solution();
        ListNode head = solution.mergeTwoLists(h1,h2);
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
