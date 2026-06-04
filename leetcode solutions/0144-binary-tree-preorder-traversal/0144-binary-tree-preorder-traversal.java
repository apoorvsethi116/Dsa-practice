class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        // Base case: if the node is null, just return
        if (node == null) {
            return;
        }
        
        // 1. Visit the Root
        result.add(node.val);
        
        // 2. Traverse the Left subtree
        traverse(node.left, result);
        
        // 3. Traverse the Right subtree
        traverse(node.right, result);
    }
}