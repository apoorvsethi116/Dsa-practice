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
    
    public int maxSum = Integer.MIN_VALUE;

    public int max(TreeNode root){
         if(root == null){
            return 0;
        }
        int ls = Math.max(max(root.left) , 0);
        int rs = Math.max(max(root.right) , 0);

        int currSum = root.val + ls + rs;

        maxSum = Math.max(maxSum , currSum);

        return root.val + Math.max(ls, rs);
    }

    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }
}