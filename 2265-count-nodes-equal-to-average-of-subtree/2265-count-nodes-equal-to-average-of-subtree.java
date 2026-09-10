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

    public int count = 0;
    
    public int[] sum(TreeNode root){
        if(root == null){
            return new int[]{0 , 0};
        }

        int[] ls = sum(root.left);
        int[] rs = sum(root.right);

       if ((root.val + ls[0] + rs[0]) / (1 + ls[1] + rs[1]) == root.val) {
    count++;
}


        return new int[]{root.val + ls[0] + rs[0] , 1 + ls[1] + rs[1]};
    }
    public int averageOfSubtree(TreeNode root) {
        sum(root);
        return count;
    }
}