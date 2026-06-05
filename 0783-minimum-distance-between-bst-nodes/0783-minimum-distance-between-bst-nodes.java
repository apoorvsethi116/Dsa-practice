import java.util.ArrayList;

class Solution {
    // We pass the same list 'a' into the helper method to collect all values
    private void traver(TreeNode root, ArrayList<Integer> a) {
        if (root == null) {
            return; // Just return if the node is empty
        }
        
        // In-order traversal: Left, Root, Right (keeps elements sorted)
        traver(root.left, a);
        a.add(root.val);
        traver(root.right, a);
    }

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        
        // Fill the list using our traversal helper
        traver(root, list);
        
        // Loop through the sorted list and find the minimum difference
        // Note: We stop at list.size() - 1 so i + 1 doesn't go out of bounds
        for (int i = 0; i < list.size() - 1; i++) {
            // list.get(i) is how you access ArrayList elements in Java
            int diff = list.get(i + 1) - list.get(i); 
            min = Math.min(min, diff);
        } 

        return min;
    }
}