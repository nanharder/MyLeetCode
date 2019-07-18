package Arraymove;

/**
 * remove elements in linkedlists
 */
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode par = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                par.next = cur;
            } else {
                par = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
