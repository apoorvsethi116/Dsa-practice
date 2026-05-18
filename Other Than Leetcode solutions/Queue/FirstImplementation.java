package Queue;

public class FirstImplementation {
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;

        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        //enqueue
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        //dequeue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("is empty");
                return -1;
            }
            int el = arr[0];//front element
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];

            }
            rear--;
            return el;
        }

        //peek to see front
        public static int peek() {
            if (isEmpty()) {
                System.out.println("is empty");
                return -1;
            }

            return arr[0];
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




