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
    public ArrayList<Integer> in(TreeNode root , ArrayList<Integer> res){
        if(root == null){
            return res;
        }

        in(root.left , res);
        res.add(root.val);
        in(root.right , res);

        return res;
    }
    public TreeNode build(ArrayList<Integer> in , int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(in.get(mid));

        root.left = build(in , start , mid-1);
        root.right = build(in , mid+1 , end);


        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> in = in(root , new ArrayList<Integer>());

        return build(in , 0 , in.size()-1);
    }
}