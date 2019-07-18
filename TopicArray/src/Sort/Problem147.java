package Sort;

public class Problem147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pasthead = new ListNode(0);
        pasthead.next = head;
        ListNode cur = head.next;
        ListNode last = head;
        ListNode pointer, remain;
        while (cur != null) {
            remain = cur.next;
            pointer = pasthead;
            if (cur.val >= last.val) {
                last = cur;
                cur = remain;
                continue;
            }
            while (pointer != cur) {
                if (cur.val < pointer.next.val) {
                    cur.next = pointer.next;
                    pointer.next = cur;
                    last.next = remain;
                    cur = remain;
                    break;
                }
                pointer = pointer.next;
            }
        }
        return pasthead.next;
    }


    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        insertionSortList(n1);
    }
}
