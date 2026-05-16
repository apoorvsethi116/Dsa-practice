package Stack;

public class StackLL {
    static class Stack{
        public class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }

        }

        public Node head;

        //isEmpty
        public boolean isEmpty(){
            if(head == null){
                return true;
            }
            return false;
        }

        //push
        public void push(int data){

            Node n = new Node(data);
            if(isEmpty()){
                head = n;
                return;
            }
            n.next = head;
            head = n;

        }

        //pop
        public int pop(){
            if(isEmpty()){

                return -1;
            }
            int del = head.data;
            head = head.next;
            return del;
        }

        //peek
        public int peek(){
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
