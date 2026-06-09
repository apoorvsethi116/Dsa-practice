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
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int a = Math.max(lh , rh) + 1;
        return a;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);

        int leftH = height(root.left);
        int rightH = height(root.right);

        int selfD = (leftH + 1) + (rightH + 1);
        return Math.max(selfD , Math.max(leftD , rightD));
    }
}