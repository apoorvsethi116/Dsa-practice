/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node level(Node root){
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        root.next = null;

        while(!q.isEmpty()){
            int lsize = q.size();
            for(int i = 0; i<lsize; i++ ){
                Node curr = q.remove();

                if(i < lsize - 1){
                    curr.next = q.peek();
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                 if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
    public Node connect(Node root) {
        return level(root);
    }
}