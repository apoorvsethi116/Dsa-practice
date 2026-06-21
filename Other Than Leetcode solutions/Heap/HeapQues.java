package Heap;

import java.util.ArrayList;

public class HeapQues {
    public static class heap {
        ArrayList<Integer> a = new ArrayList<>();

        public void add(int data) {
            a.add(data);

            int child = a.size() - 1;
            int par = (child - 1) / 2;

            // FIX 1: Ensure child > 0 so we don't compare the root with itself
            while (child > 0 && a.get(child) < a.get(par)) {
                // Swap
                int temp = a.get(child);
                a.set(child, a.get(par));
                a.set(par, temp);

                // FIX 2: Move the pointers up the tree!
                child = par;
                par = (child - 1) / 2;
            }
        }

        public int peek() {
            if (a.isEmpty()) return -1; // Defensive check
            return a.get(0);
        }

        public void print() {
            System.out.println(a);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // Assume current parent is the minimum

            // If left child exists and is smaller than current minimum
            if (left < a.size() && a.get(left) < a.get(minIdx)) {
                minIdx = left;
            }

            // If right child exists and is smaller than current minimum
            if (right < a.size() && a.get(right) < a.get(minIdx)) {
                minIdx = right;
            }

            // If the minimum element is not the parent, swap and continue down
            if (minIdx != i) {
                int temp = a.get(i);
                a.set(i, a.get(minIdx));
                a.set(minIdx, temp);

                // Recursively look down the tree
                heapify(minIdx);
            }
        }

        public int delete(){
            if (a.isEmpty()) {
                System.out.println("Heap is empty!");
                return -1;
            }
            int min = a.get(0);

            a.set(0 , a.get(a.size()  - 1));

            a.remove(a.size() - 1);

            if(!a.isEmpty()){
                heapify(0);
            }

            return min;

        }
    }

    public static void main(String[] args) {
        heap h = new heap();
        h.add(2);
        h.add(3);
        h.add(5);
        h.add(7);

        h.print(); // Expected output for Max-Heap: [7, 5, 3, 2]

        h.delete();
        h.print();
    }
}