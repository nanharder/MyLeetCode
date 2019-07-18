package Sort;

/**
 * simple but not skilled
 */
public class Problem148 {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len += 1;
            cur = cur.next;
        }

        ListNode pastHead = new ListNode(0);
        pastHead.next = head;
        ListNode left, right, tail;
        for (int n = 1; n < len; n *= 2) {
            cur = pastHead.next;
            tail = pastHead;
            while (cur != null) {
                left = cur;
                right = split(left, n);
                cur = split(right, n);
                ListNode[] merged = mergeTwoLists(left, right);
                tail.next = merged[0];
                tail = merged[1];
            }
        }
        return pastHead.next;
    }

    private ListNode split(ListNode node, int n) {
        for (int i = 0; i < n - 1; i += 1) {
            if (node == null) {
                break;
            }
            node = node.next;
        }
        ListNode rest = node == null ? null : node.next;
        if (node != null) {
            node.next = null;
        }
        return rest;
    }

    private ListNode[] mergeTwoLists(ListNode l1, ListNode l2) {
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
        while (target.next != null) {
            target = target.next;
        }
        ListNode[] results = new ListNode[]{head.next, target};
        return results;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
