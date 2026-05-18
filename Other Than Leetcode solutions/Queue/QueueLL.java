package Queue;

public class QueueLL {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class
    static class Queue {

        // removed static
        Node head = null;
        Node tail = null;

        // check empty
        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // add element
        public void add(int data) {

            Node n = new Node(data);

            // first element
            if (isEmpty()) {
                head = tail = n;
                return;
            }

            // connect old tail to new node
            tail.next = n;

            // move tail to new node
            tail = n;
        }

        // remove element
        public int remove() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;

            // single element
            if (head == tail) {
                head = tail = null;
                return front;
            }

            // move head forward
            head = head.next;

            return front;
        }

        // peek front element
        public int peek() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {

        // create queue object
        Queue q = new Queue();

        // add elements
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        // print and remove elements
        while (!q.isEmpty()) {

            System.out.println("Front element = " + q.peek());

            q.remove();
        }
    }
}