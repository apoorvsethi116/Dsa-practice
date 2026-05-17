/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        // edge cases
        if(head == null || head.next == null || k == 0){
            return head;
        }

        // STEP 1:
        // find length of linked list

        int length = 1;

        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        // STEP 2:
        // if k is bigger than length

        k = k % length;

        // if no rotation needed
        if(k == 0){
            return head;
        }

        // STEP 3:
        // use two pointers

        ListNode fast = head;
        ListNode slow = head;

        // move fast pointer k steps ahead

        for(int i = 0; i < k; i++){
            fast = fast.next;
        }

        // STEP 4:
        // move both together
        // when fast reaches last node,
        // slow will be before new head

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // STEP 5:
        // rotation work

        ListNode newHead = slow.next;

        // break list
        slow.next = null;

        // connect old tail to old head
        fast.next = head;

        return newHead;
    }
}