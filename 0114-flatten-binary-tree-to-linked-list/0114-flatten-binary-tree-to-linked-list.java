class Solution {
    // Helper function that returns the TAIL (last node) of the newly built list
    public TreeNode buildNewList(TreeNode root, TreeNode currentTail) {
        if (root == null) {
            return currentTail;
        }
        
        // 1. Create a new node for the current value and attach it to the tail's right
        currentTail.right = new TreeNode(root.val);
        currentTail.left = null; // Ensure the left pointer stays null
        
        // Move our tail pointer to this newly added node
        currentTail = currentTail.right;
        
        // 2. Process the left subtree first (Pre-order: Root -> Left -> Right)
        currentTail = buildNewList(root.left, currentTail);
        
        // 3. Process the right subtree next
        currentTail = buildNewList(root.right, currentTail);
        
        return currentTail;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // Create a dummy head to easily build the new structure
        TreeNode dummy = new TreeNode(0);
        
        // Build the new flattened tree attached to the dummy node
        buildNewList(root, dummy);
        
        // Since LeetCode expects us to modify the original 'root' in-place,
        // we copy the structure of our new tree directly onto the original root.
        root.left = null;
        root.right = dummy.right.right; 
    }
}