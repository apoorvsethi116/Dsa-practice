package LinkedList;
import java.util.*;
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
            return;
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

    public int removeFirst(){
        if(size == 0){
            System.out.println("list is empty");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head =  tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    //more safer logic
    public int removeLast() {
        if (size == 0) return Integer.MIN_VALUE;
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // Using the loop from the video is safer than .next.next
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // or tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //self made logic
//    public int removeLast(){
//        if(size == 0 || head == null){
//            System.out.println("ll is empty");
//            return Integer.MIN_VALUE;
//        }
//        if(size == 1 || head == tail){
//            int val = head.data;
//            head = tail = null;
//            size = 0;
//            return val;
//        }
//
//        Node temp = head;
//
//        while(temp.next.next != null){
//            temp = temp.next;
//        }
//        int val = temp.next.data;
//        tail = temp;
//        temp.next = null;
//        size--;
//
//        return val;
//    }

    public void reverse(){

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
        ll.removeFirst();
        //ll.removeLast();
        ll.print();
        System.out.println("size of ll: " + size);

    }

}
