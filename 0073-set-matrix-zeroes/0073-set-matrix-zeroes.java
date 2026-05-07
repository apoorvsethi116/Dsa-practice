class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1. Check if first row needs to be zeroed later
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // 2. Check if first column needs to be zeroed later
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }

        // 3. Use first row/col to mark zeros for the rest of the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. Zero out cells based on marks in first row/col
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. Finally, handle the first row and column themselves
        if (firstRowZero) {
            for (int j = 0; j < m; j++) matrix[0][j] = 0;
        }
        if (firstColZero) {
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }
    }
}