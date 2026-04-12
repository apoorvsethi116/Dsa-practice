package LinkedList;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){

        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int idx , int data){
        if(idx == 0){
            addFirst(data);
        }
        Node temp = head;
        int i = 0;
        while (i != idx-1){
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void print(){
        if(head == null){
            System.out.println("Empty list!");
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }


    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        //ll.print();
        //System.out.println("--------------------------------");
        ll.addFirst(1);
        ll.addFirst(2);
        //ll.print();
        //System.out.println("--------------------------------");

        ll.addlast(3);
        ll.addlast(4);
        ll.print();
        System.out.println("size of ll: " + size);
        System.out.println("--------------------------------");

        ll.addMiddle(2 , 0);
        ll.print();
        System.out.println("size of ll: " + size);

    }

}
