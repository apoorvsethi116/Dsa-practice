/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size(); // Fixed: changed 'queue' to 'q'
            List<Integer> n = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) { // Fixed: removed () from levelSize
                TreeNode curr = q.remove();
                n.add(curr.val);

                // Add left child to the queue if it exists
                if (curr.left != null) {
                    q.add(curr.left);
                }
                // Add right child to the queue if it exists
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            ans.add(n); // Fixed: added missing semicolon
        }

        return ans; // Fixed: added missing semicolon
    }
}