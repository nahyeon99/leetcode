package leetcode.SortList;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // split
        ListNode prev = null, slow = head, fast = head;

        // 4, 2, 1, 3

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // prev 없으면 StackOverflowError

        // split recursion
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        // merge
        return mergeSort(node1, node2);
    }

    ListNode mergeSort(ListNode node1, ListNode node2) {

        ListNode node = new ListNode(0), point = node;

        // CASE1: left, right 둘 다 남았을 때
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                point.next = node1;
                node1 = node1.next;
            } else {
                point.next = node2;
                node2 = node2.next;
            }
            point = point.next;
        }

        // CASE2: left 만 남은 경우
        if (node1 != null)
            point.next = node1;

        // CASE3: right 만 남은 경우
        if (node2 != null)
            point.next = node2;

        return node.next; // head return
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(3, null);
        ListNode node1 = new ListNode(1, node);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(4, node2);

        System.out.println(s.sortList(node3));
    }
}