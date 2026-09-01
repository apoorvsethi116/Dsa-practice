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
    public boolean isPalindrome(ListNode head) {
       

        ListNode temp = head;
        ListNode ntemp =head;

        Stack<Integer> s = new Stack<>();

        while(temp != null){
            s.push(temp.val);
            temp = temp.next;
        }

        while(!s.isEmpty() && ntemp != null){
            if(s.pop() != ntemp.val){
                return false;
            }
            ntemp = ntemp.next;
        }


        return true;
    }
}