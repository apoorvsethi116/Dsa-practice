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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Setup dummy node to handle cases where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move 'prev' to the node at position (left - 1)
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 3: Reverse the segment [left, right]
        // 'curr' will be the first node of the segment to be reversed
        ListNode curr = prev.next; 
        
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;     // The node we are moving
            curr.next = temp.next;         // Bridge curr to the node after temp
            temp.next = prev.next;         // Move temp to the front of the reversed part
            prev.next = temp;              // Connect prev to the new front
        }

        return dummy.next;
    }
}