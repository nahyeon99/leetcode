package AddTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode resultHead = new ListNode(0);

        ListNode node1 = l1, node2 = l2;

        int sum = 0;

        while (node1 != null || node2 != null) {

            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }

            result.next = new ListNode(sum % 10);
            result = result.next;
            if (resultHead.next == null)
                resultHead.next = result;
            sum /= 10;
        }
        if (sum == 1) {
            result.next = new ListNode(1);
        }
        return resultHead.next;
    }
}