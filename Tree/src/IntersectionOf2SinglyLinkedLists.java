public class IntersectionOf2SinglyLinkedLists {

    public class Solution0 {

        //Your code should preferably run in O(n) time and use only O(1) memory.
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null)
                return null;
            ListNode a = headA;
            ListNode b = headB;
            while (a!=null && b!=null){
                a = a.next;
                b = b.next;
            }

            //接下来，将 a和b拉平
            int cnt = 0;
            if(a==null){
                while (b!=null){
                    b = b.next;
                    cnt++;
                }
                a = headA;
                b = headB;
                while (cnt!=0){
                    b = b.next;
                    cnt--;
                }
            }
            else{
                while (a!=null){
                    a = a.next;
                    cnt++;
                }
                a = headA;
                b = headB;
                while (cnt!=0){
                    a = a.next;
                    cnt--;
                }
            }

            while (a!=null && b!=null){
                if(a == b)
                    return a;
                else{
                    a = a.next;
                    b = b.next;
                }
            }
            return null;
        }
    }

    public class Solution{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null)
                return null;
            ListNode a = headA;
            ListNode b = headB;
            while(a!=b){
                if(a==null)  //走完第一程
                    a = headB;  //精髓，开始第二程，两个指针走过的距离都是l1+l2
                else a = a.next;
                if(b == null)
                    b = headA;
                else b = b.next;
            }
            return a;  //如果有交点，则两个指针会相遇；如果没有，则a == b == null
        }
    }
}
