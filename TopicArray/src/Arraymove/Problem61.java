package Arraymove;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len += 1;
            cur = cur.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        cur.next = head;
        cur = head;
        for (int i = 0; i < len - k - 1; i += 1) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
