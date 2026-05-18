package Queue;

public class CircularQueue {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;

        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear +1) % size == front;
        }

        //enqueue
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            //adding first time ie front & rear = -1
            if(front == -1){
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //dequeue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("is empty");
                return -1;
            }
            int el = arr[front];//front element
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
            return el;
        }

        //peek to see front
        public static int peek() {
            if (isEmpty()) {
                System.out.println("is empty");
                return -1;
            }

            return arr[front];
        }

    }


    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}




