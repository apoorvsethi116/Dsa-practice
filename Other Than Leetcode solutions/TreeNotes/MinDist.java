package TreeNotes;
import java.util.*;

//minimum distance between two nodes
public class MinDist {
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

    public static void main(String[] args) {
        Tree root = new Tree(10);

        root.left = new Tree(7);
        root.right = new Tree(15);

        root.left.left = new Tree(5);
        root.left.right = new Tree(6);

        root.right.left = new Tree(12);
        root.right.right = new Tree(16);

        root.right.right.right = new Tree(20);
    }
}
