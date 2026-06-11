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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 1;
        int maxLevel = 1;

        while(!q.isEmpty()){
            int currentSum = 0;
            int levelSize = q.size();

            for(int i = 0 ; i < levelSize; i++){
                TreeNode curr = q.remove();
                currentSum += curr.val;

                if(curr.left != null){
                    q.add(curr.left);
                }

                 if(curr.right != null){
                    q.add(curr.right);
                }
            }

           if(currentSum > maxSum){
            maxSum = currentSum;
            maxLevel = currentLevel;
           }
           currentLevel ++;
        }

        return maxLevel;
    }
}