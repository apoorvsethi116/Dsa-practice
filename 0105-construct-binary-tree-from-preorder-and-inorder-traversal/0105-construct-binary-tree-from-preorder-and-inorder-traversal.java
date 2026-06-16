/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store the value -> index of inorder elements for O(1) lookups
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return splitAndBuild(preorder, 0, preorder.length - 1, 
                             inorder, 0, inorder.length - 1, inMap);
    }
    
    private TreeNode splitAndBuild(int[] preorder, int preStart, int preEnd, 
                                   int[] inorder, int inStart, int inEnd, 
                                   Map<Integer, Integer> inMap) {
        
        // Base case: if there are no elements to process in this subtree range
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // 1. The first element in the current preorder range is ALWAYS the root
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // 2. Find where this root sits in the inorder array
        int inRootIdx = inMap.get(root.val);
        
        // 3. Calculate exactly how many elements are in the left subtree
        int numsLeft = inRootIdx - inStart;
        
        // 4. Recursively build the left and right subtrees by shifting the boundaries
        
        // Left subtree:
        // Preorder: Skip the root (preStart + 1) and grab 'numsLeft' elements
        // Inorder: Everything from 'inStart' up to the element right before the root
        root.left = splitAndBuild(preorder, preStart + 1, preStart + numsLeft, 
                                  inorder, inStart, inRootIdx - 1, inMap);
                                  
        // Right subtree:
        // Preorder: Skip the root AND all left elements (preStart + numsLeft + 1) to the end
        // Inorder: Everything from the element right after the root to 'inEnd'
        root.right = splitAndBuild(preorder, preStart + numsLeft + 1, preEnd, 
                                   inorder, inRootIdx + 1, inEnd, inMap);
        
        return root;
    }
}