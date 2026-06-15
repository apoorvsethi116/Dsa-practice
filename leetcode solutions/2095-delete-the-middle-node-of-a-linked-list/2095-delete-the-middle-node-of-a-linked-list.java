/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge Case: If the list has only 1 node, the middle node is the head itself.
        // Deleting it leaves an empty list, so we return null.
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow at head, and fast two steps ahead.
        // This ensures that when fast reaches the end, slow stops right 
        // BEFORE the actual middle node.
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now the predecessor of the middle node.
        // Bypassing the middle node deletes it.
        slow.next = slow.next.next;

        return head;
    }
}