package Add;

import java.util.Stack;

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        while (l1 != null) {
            num1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.add(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode res = new ListNode(0);
        while (!num1.empty() || !num2.empty()) {
            if (!num1.empty()) {
                sum += num1.pop();
            }
            if (!num2.empty()) {
                sum += num2.pop();
            }
            res.val = sum % 10;
            ListNode cur = new ListNode(sum / 10);
            cur.next = res;
            res = cur;
            sum /= 10;
        }

        return res.val == 0 ? res.next : res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
