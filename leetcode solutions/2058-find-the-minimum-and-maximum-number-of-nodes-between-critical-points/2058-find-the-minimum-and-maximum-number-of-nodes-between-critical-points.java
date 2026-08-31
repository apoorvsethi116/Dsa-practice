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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ArrayList<Integer> point = new ArrayList<>();

        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        int pos = 1;

        while (c != null) {
            if ((b.val < c.val && b.val < a.val) || (b.val > c.val && b.val > a.val)) {
                point.add(pos);
            }
            c = c.next;
            b = b.next;
            a = a.next;
            pos++;

        }

        if (point.size() < 2) {
            return ans;
        }

        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < point.size() - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(point.get(i) - point.get(i + 1)));

            maxDiff = Math.max(maxDiff, Math.abs(point.get(i + 1) - point.get(0)));
        }

        ans[0] = minDiff;
        ans[1] = maxDiff;

        return ans;
    }
}