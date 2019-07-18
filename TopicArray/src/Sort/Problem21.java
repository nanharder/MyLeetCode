package Sort;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode target = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                target.next = l1;
                l1 = l1.next;
            } else {
                target.next = l2;
                l2 = l2.next;
            }
            target = target.next;
        }
        if (l1 != null) {
            target.next = l1;
        } else {
            target.next = l2;
        }
        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
