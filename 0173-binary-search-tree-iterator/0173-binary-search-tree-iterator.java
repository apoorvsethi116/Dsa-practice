import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
    // Deque is preferred over the legacy Stack class in Java
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        // Push the root and all its left-most descendants
        pushAllLeft(root);
    }
    
    public int next() {
        // The top of the stack is always the next smallest element
        TreeNode node = stack.pop();
        
        // If this node has a right child, we must process it 
        // and all of its left-most descendants
        if (node.right != null) {
            pushAllLeft(node.right);
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        // If the stack is not empty, there are still nodes left to visit
        return !stack.isEmpty();
    }
    
    // Helper method to push a node and all of its left children onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}