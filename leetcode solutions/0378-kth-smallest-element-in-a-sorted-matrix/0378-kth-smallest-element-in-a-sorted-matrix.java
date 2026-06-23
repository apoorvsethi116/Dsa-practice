import java.util.PriorityQueue;

class Solution {
    // 1. Made static and implemented Comparable so PriorityQueue knows how to sort it
    public static class data implements Comparable<data> {
        int row;
        int col;
        int val;

        public data(int i, int j, int val) {
            this.row = i;
            this.col = j;
            this.val = val;
        }

        @Override
        public int compareTo(data other) {
            return Integer.compare(this.val, other.val); // Min-Heap based on 'val'
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<data> pq = new PriorityQueue<>();
        
        // Populate the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            pq.add(new data(i, 0, matrix[i][0]));
        }
        
        // We need to pop k-1 times to reach the kth smallest element
        for (int count = 0; count < k - 1; count++) {
            data current = pq.poll(); // Get the smallest current element
            
            // --- THE NEXT STEP YOU ASKED FOR ---
            // If there is a next element in the same row, add it to the heap
            if (current.col + 1 < matrix[current.row].length) {
                pq.add(new data(
                    current.row, 
                    current.col + 1, 
                    matrix[current.row][current.col + 1]
                ));
            }
        }
        
        // The top of the heap is now the kth smallest element
        return pq.poll().val;
    }
}