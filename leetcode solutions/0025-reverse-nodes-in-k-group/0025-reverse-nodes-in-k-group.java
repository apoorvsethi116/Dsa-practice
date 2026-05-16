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
class Solution {
   
    public ListNode reverseKGroup(ListNode head, int k) {
       
    // Step 1: Check if there are at least k nodes left
    ListNode current = head;
    int count = 0;
    
    while (current != null && count < k) {
        current = current.next;
        count++;
    }
    
    // If we counted fewer than k nodes, leave them as they are!
    if (count < k) {
        return head;
    }
    
    // Step 2: Reverse the current group of k nodes
    ListNode prev = null;
    ListNode curr = head;
    ListNode nextNode = null;
    
    for (int i = 0; i < k; i++) {
        nextNode = curr.next; // Save the next node before breaking the link
        curr.next = prev;     // Flip the pointer backwards
        prev = curr;          // Move prev one step forward
        curr = nextNode;      // Move curr one step forward
    }
    
    // Step 3: Connect this group to the next groups
    // After the loop, 'head' is now the TAIL of our newly reversed group.
    // 'nextNode' (or 'curr') is pointing to the start of the NEXT group.
    if (nextNode != null) {
        // Recursively call the function for the remaining list
        // and link our current tail to whatever head it returns!
        head.next = reverseKGroup(nextNode, k);
    }
    
    // 'prev' has become the new HEAD of this reversed block
    return prev;
}
        

    }
