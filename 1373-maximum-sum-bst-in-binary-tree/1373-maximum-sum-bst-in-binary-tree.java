class Solution {
    public class info {
        boolean isBST;
        int min;
        int max;
        int sum;

        public info(boolean isBST , int min , int max , int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSum = 0;
    
    public info solve(TreeNode root){
        if (root == null) {
            return new info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        info Linfo = solve(root.left);
        info Rinfo = solve(root.right);

        // COMBINED CHECK: 
        // If left is fake, right is fake, or root breaks boundaries -> This entire tree is invalid.
        if (!Linfo.isBST || !Rinfo.isBST || Linfo.max >= root.val || Rinfo.min <= root.val) {
            // Return false immediately. 
            // Dummy values (0, 0, 0) ensure parents won't accidentally mistake this for a valid BST path.
            return new info(false, 0, 0, 0);
        }

        // If we clear the check above, we are 100% certain this node forms a VALID BST.
        int sum = Linfo.sum + Rinfo.sum + root.val;
        maxSum = Math.max(sum, maxSum);

        // Track the true min/max bounds of this valid BST to pass to the parent
        int min = Math.min(root.val, Linfo.min);
        int max = Math.max(root.val, Rinfo.max);

        return new info(true, min, max, sum);
    }

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        solve(root);
        return maxSum;
    }
}