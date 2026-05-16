package LinkedList;

public class DeepCopy {

    // Definition for a Node
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Function to copy list with random pointer (O(1) space approach)
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp = head;

        // Step 1: Insert copy nodes in between
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Assign random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate original and copied list
        temp = head;
        Node newHead = head.next;

        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            temp = temp.next;
        }

        return newHead;
    }

    // Helper function to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + " | Random: " + randomVal);
            temp = temp.next;
        }
        System.out.println("------");
    }

    public static void main(String[] args) {

        DeepCopy obj = new DeepCopy();

        // Create sample list:
        // 1 -> 2 -> 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        // Random pointers
        n1.random = n3; // 1 → 3
        n2.random = n1; // 2 → 1
        n3.random = null; // 3 → null

        System.out.println("Original List:");
        printList(n1);

        Node copiedHead = obj.copyRandomList(n1);

        System.out.println("Copied List:");
        printList(copiedHead);
    }
}