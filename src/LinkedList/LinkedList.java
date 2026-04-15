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
        Node curr = head;
        Node next;

        tail = head; // after reverse, old head becomes tail

        while (curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev;
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

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addlast(3);
        ll.addlast(4);

        ll.print();

        System.out.println("Size: " + size);

        ll.addMiddle(2, 0);
        ll.print();

        // Search tests
        System.out.println("Iterative Search (3): " + ll.iterativeSearch(3));
        System.out.println("Recursive Search (4): " + ll.recursiveSearch(4));

        // Reverse
        ll.reverse();
        System.out.println("After reverse:");
        ll.print();

        ll.removeFirst();
        ll.removeLast();

        ll.print();
        System.out.println("Size: " + size);
    }
}