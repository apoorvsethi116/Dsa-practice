/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traversal(ArrayList<Integer> l , TreeNode root){
        if(root == null){
            return;
        }

        traversal(l , root.left);
        traversal(l , root.right);
        l.add(root.val);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();

        traversal(l , root);

        return l;
    }
}