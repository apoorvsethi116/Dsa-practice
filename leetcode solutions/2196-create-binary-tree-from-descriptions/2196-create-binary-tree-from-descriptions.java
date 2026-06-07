import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store value -> TreeNode mapping
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to track all children values
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
            
            // Get or create parent node
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parent = nodeMap.get(parentVal);
            
            // Get or create child node
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode child = nodeMap.get(childVal);
            
            // Link parent and child
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            // Mark this node as a child
            children.add(childVal);
        }
        
        // The root is the parent node that never appears in the children set
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        
        return null;
    }
}