package TreeNotes;
import java.util.*;

public class TopView {
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

    static class info{
        Tree node;
        int hd;

        info(Tree root , int hd){
            this.node = root;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> topView(Tree root){
        Queue<info> q = new LinkedList<>();
        HashMap<Integer , Tree> map = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        int min = 0 , max = 0;
        q.add(new info(root , 0));
        q.add(null);

        while(!q.isEmpty()){
            int level = q.size();

            for(int i = 0; i<level; i++){
                info currNode = q.remove();
                if(currNode == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(currNode.hd)){
                        map.put(currNode.hd , currNode.node);
                    }

                    if(currNode.node.left != null){
                        q.add(new info(currNode.node.left , currNode.hd-1));
                        min = Math.min(min , currNode.hd-1);
                    }
                    if(currNode.node.right != null){
                        q.add(new info(currNode.node.right , currNode.hd+1));
                        max = Math.max(max , currNode.hd+1);
                    }
                }

            }
        }

        for(int i = min; i<=max; i++){
           a.add( map.get(i).data);
        }

        return a;

    }

    public static ArrayList<Integer> bottomView(Tree root){

        Queue<info> q = new LinkedList<>();
        HashMap<Integer , Tree> map = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        int min = 0 , max = 0;
        q.add(new info(root , 0));
        q.add(null);

        while(!q.isEmpty()){
            int level = q.size();

            for(int i = 0; i<level; i++){
                info currNode = q.remove();
                if(currNode == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    // Just update the map directly without checking if it already exists!
                    map.put(currNode.hd, currNode.node);

                    if(currNode.node.left != null){
                        q.add(new info(currNode.node.left , currNode.hd-1));
                        min = Math.min(min , currNode.hd-1);
                    }
                    if(currNode.node.right != null){
                        q.add(new info(currNode.node.right , currNode.hd+1));
                        max = Math.max(max , currNode.hd+1);
                    }
                }

            }
        }

        for(int i = min; i<=max; i++){
            a.add( map.get(i).data);
        }

        return a;

    }

    public static void main(String[] args) {
        Tree root = new Tree(10);

        root.left = new Tree(7);
        root.right = new Tree(15);

        root.left.left = new Tree(5);
        root.left.right = new Tree(6);

        root.right.left = new Tree(12);
        root.right.right = new Tree(16);

        root.right.right.right = new Tree(20);


        System.out.println(topView(root));
        System.out.println(bottomView(root));

    }
}
