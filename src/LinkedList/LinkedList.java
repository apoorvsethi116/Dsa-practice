package LinkedList;
import java.util.*;

public class LinkedList {

    // Node class representing each element
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add element at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add element at end
    public void addlast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Add element at specific index
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 0;

        while (i != idx - 1) {
            temp = temp.next;
            i++;
        }

        Node newNode = new Node(data);
        size++;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first element
    public int removeFirst() {
        if (size == 0) {
            System.out.println("list is empty");
            return -1;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    // Remove last element (safe approach)
    public int removeLast() {
        if (size == 0) return Integer.MIN_VALUE;

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;

        // Move to second last node
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    // ===============================
    // ITERATIVE SEARCH
    // ===============================
    // Returns index of key, else -1
    public int iterativeSearch(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1; // not found
    }

    // ===============================
    // RECURSIVE SEARCH
    // ===============================
    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    // Helper function for recursion
    private int helper(Node head, int key) {
        // base case
        if (head == null) return -1;

        if (head.data == key) return 0;

        int idx = helper(head.next, key);

        if (idx == -1) return -1;

        return idx + 1;
    }

    // ===============================
    // REVERSE LINKED LIST
    // ===============================
    public void reverse() {
        Node prev = null;
        Node curr = tail =  head; // after reverse, old head becomes tail
        Node next;

        while (curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev;
    }

    //find and remove nth node from end
    //of the linked list #amazon question

    public void removeNthFromEnd(int n){
        int Vsize = 0;
        int count = 1;
        Node temp = head;
        Node hand = head;

        while(temp != null){
            temp = temp.next;
            Vsize++;
        }

        if(n == Vsize){
            head = head.next;
            size--;
            return;
        }
        while(count != Vsize-n){
            hand = hand.next;
            count++;
        }

        hand.next = hand.next.next;
        size--;

    }

    public boolean pallindrome(){
        if(head == null || head.next==null){
            return true;
        }
        //find mid
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {  // odd length
            slow = slow.next;
        }//skipping the need to comapre mid elem from itself


        //reverse right half
        Node prev = null;
        Node curr = slow;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //check if left == right
        Node left = head;
        Node right = prev;
        Node reversedHalfHead = right; // preserving value for restoration
        boolean isPallindrome = true;

        while(right != null) {
            if (left.data != right.data) {
              isPallindrome = false;
              break;
            }
            left = left.next;
            right = right.next;
        }

        //restore original Linkedlist
        Node prev1 = null;
        Node curr1 = reversedHalfHead;
        Node next1;

        while(curr1 != null){
            next1 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = next1;
        }


        return isPallindrome;
    }

    public boolean hasCycle() {
        Node slow;
        Node fast;

        slow = fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }


        }

        return false;
    }
    public void removeCycle() {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        // 1. DETECTION: Find the meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Cycle detected
            }
        }

        // If loop finished without finding slow == fast
        if (slow != fast) return;

        // 2. CORRECTION: Reset slow to head, find the junction
        slow = head;
        Node prev = null; // This will track the node JUST BEFORE the junction

        // Handle Edge Case: Cycle starts exactly at the Head
        if (slow == fast) {
            // Move fast until its .next is head
            while (fast.next != head) {
                fast = fast.next;
            }
            fast.next = null; // Break it
        }
        else {
            // General Case: Move both until they meet at the entry
            while (slow != fast) {
                prev = fast;  // Keep track of the 'tail'
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null; // Break it
        }
    }

        // Print LinkedList
    public void print() {
        if (head == null) {
            System.out.println("Empty list!");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

//        ll.addFirst(3);
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addlast(1);
//        ll.addlast(2);

        //cycle
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);

        Node temp = new Node(3);
        head.next.next.next = temp;
        temp.next = new Node(4);
        temp.next.next = temp;


        System.out.println("has cycle? :" + ll.hasCycle() );

        ll.removeCycle();
        System.out.println("has cycle? :" + ll.hasCycle() );

        // Search tests
//        System.out.println("Iterative Search (3): " + ll.iterativeSearch(3));
//        System.out.println("Recursive Search (4): " + ll.recursiveSearch(4));

        // Reverse
//        ll.reverse();
//        System.out.println("After reverse:");
        //ll.print();

//        ll.removeFirst();
//        ll.removeLast();
//        System.out.println("Size: " + size);
//        ll.removeNthFromEnd(2);
//        ll.print();
//        System.out.println("pallindrome? :" + ll.pallindrome());
//        System.out.println("pallindrome? :" + ll.pallindrome());
        System.out.println("Size: " + size);
    }
}