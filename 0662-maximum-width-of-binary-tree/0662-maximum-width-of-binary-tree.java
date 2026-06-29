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
    public class pair{
        TreeNode node;
        int idx;

        public pair(TreeNode node , int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        int maxWidth = 0;
        q.add(new pair(root , 0));

        while(!q.isEmpty()){
            pair curr = q.peek();
            int leftBound = curr.idx;
            int rightBound = leftBound;

            int levelSize = q.size();

            for(int i = 0; i<levelSize; i++){
                pair temp = q.remove();
                rightBound = temp.idx;

                if(temp.node.left!=null){
                    q.add(new pair(temp.node.left , 2*temp.idx +1));
                }
                 if(temp.node.right!=null){
                    q.add(new pair(temp.node.right , 2*temp.idx +2));
                }
            }

            int currWidth = rightBound - leftBound + 1;
            maxWidth = Math.max(maxWidth , currWidth);
        }
          return maxWidth;
    }

  
}
