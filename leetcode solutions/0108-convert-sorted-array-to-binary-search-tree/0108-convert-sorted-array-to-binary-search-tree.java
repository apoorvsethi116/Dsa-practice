class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // Handle empty array edge case
        if (nums == null || nums.length == 0) {
            return null;
        }
        // Kick off the helper method with the full array boundaries
        return build(nums, 0, nums.length - 1);
    }

    // Helper method to recursively build the tree
    private TreeNode build(int[] nums, int start, int end) {
        // Base case: if the start index crosses the end index, there are no elements left
        if (start > end) {
            return null;
        }

        // Find the middle element to ensure the tree remains height-balanced
        int mid = start + (end - start) / 2;
        
        // Create the root node for the current subtree
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);

        // Return the current node to its parent
        return root;
    }
}