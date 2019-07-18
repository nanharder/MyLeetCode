package Arraymove;

public class Problem725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len += 1;
            cur = cur.next;
        }
        int partLen = len / k + 1;
        int numOfSmallParts = partLen * k - len;

        cur = root;
        for (int i = 0; i < k; i += 1) {
            res[i] = cur;
            int bound = i < k - numOfSmallParts ? partLen : partLen - 1;
            for (int j = 0; j < bound - 1; j += 1) {
                cur = cur.next;
            }
            if (cur != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
            }
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
