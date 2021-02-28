package LeetCode.SwordToOffer;

public class JZ22 {
    public static void main(String[] args) {

    }

    //双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (count<k) {
            fast = fast.next;
            count++;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
