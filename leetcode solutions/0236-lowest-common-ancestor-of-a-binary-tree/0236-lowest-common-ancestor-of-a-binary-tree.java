/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode lca = null;

        TreeNode lef = lowestCommonAncestor(root.left , p , q);
        TreeNode righ = lowestCommonAncestor(root.right , p , q);

     // If both sides found something, this root is the LCA
if (lef != null && righ != null) {
    return root;
}

// Otherwise, return the non-null side (if both are null, this returns null)
return lef != null ? lef : righ;
    }
}