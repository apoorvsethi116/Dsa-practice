package TreeNotes;
import java.util.*;

public class First {

        //a tree node
        static class Tree{
            int data;
            Tree left;
            Tree right;

            public Tree(int data){
                this.data = data;
                this.left = null;
                this.right = null;
            }

        }

        Tree root;

    public static void inOrder(Tree root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }

        inOrder(root.left, res);
        res.add(root.data);
        inOrder(root.right, res);
    }
    public static void preOrder(Tree root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }


        res.add(root.data);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    public static void postOrder(Tree root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }

        postOrder(root.left, res);
        postOrder(root.right, res);

        res.add(root.data);

    }

    //height
    public static int height(Tree root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh , rh) + 1;

    }

    //count of nodes
    public static int countNodes(Tree root){

        if(root == null){
            return 0;
        }
        int lc =countNodes(root.left);
        int rc = countNodes(root.right);

        int count = lc + rc + 1;
        return count;
    }

    //sum of nodes
    public static int sumNodes(Tree root){


        if(root == null){
            return 0;
        }
        int ls =sumNodes(root.left);
        int rs = sumNodes(root.right);


        return ls + rs + root.data;
    }

    //diameter of a tree o(n^2)
    public int diameterOfBinaryTree(Tree root) {
        if(root == null){
            return 0;
        }

        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);

        int leftH = height(root.left);
        int rightH = height(root.right);

        int selfD = leftH + rightH + 1;
        return Math.max(selfD , Math.max(leftD , rightD));
    }

    //diameter of a tree O(n)
    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter(Tree root) {

        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        int selfDiam = leftInfo.ht + rightInfo.ht + 1;

        int diam = Math.max(
                selfDiam,
                Math.max(leftInfo.diam, rightInfo.diam)
        );

        return new Info(diam, height);
    }

    public static void main(String[] args) {
//        //              10
//        //             /  \
//                      7    15
//                    /  \  /   \
//                   5    6 12    16
//                                  \
//                                    20
        Tree root = new Tree(10);

        root.left = new Tree(7);
        root.right = new Tree(15);

        root.left.left = new Tree(5);
        root.left.right = new Tree(6);

        root.right.left = new Tree(12);
        root.right.right = new Tree(16);

        root.right.right.right = new Tree(20);

        ArrayList<Integer> in = new ArrayList<>();
        inOrder(root, in);
        System.out.println("Inorder: " + in);

        ArrayList<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        System.out.println("Preorder: " + pre);

        ArrayList<Integer> post = new ArrayList<>();
        postOrder(root, post);
        System.out.println("Postorder: " + post);


        System.out.println(height(root));
        System.out.println(countNodes(root));
        System.out.println(sumNodes(root));
    }


}
