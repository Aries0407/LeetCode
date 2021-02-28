package LeetCode.SwordToOffer;
import java.util.LinkedList;

public class JZ24 {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    //迭代
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
