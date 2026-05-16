package LinkedList;

public class DoublyLink {

    public class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static Node Size;

    //add
    public void add(){
        
    }


    public static void main(String[] args) {
        DoublyLink dll = new DoublyLink();
    }
}
