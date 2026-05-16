package BackTracking;

import javax.swing.*;
import java.awt.*;

public class NQueensVisualizer extends JFrame {
    private int n;
    private JPanel[][] cells;
    private final int DELAY = 300; // Speed of the visualization (ms)

    public NQueensVisualizer(int n) {
        this.n = n;
        this.cells = new JPanel[n][n];
        setTitle("N-Queens Visualizer");
        setLayout(new GridLayout(n, n));

        // Create the board visually
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new JPanel();
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                // Checkerboard pattern
                cells[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                add(cells[i][j]);
            }
        }

        setSize(600, 600);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Run the algorithm in a separate thread so the UI doesn't freeze
        new Thread(() -> nQueens(0)).start();
    }

    // YOUR ORIGINAL LOGIC - Slightly modified to interact with the UI
    public boolean isSafe(int row, int col) {
        // Up
        for (int i = row - 1; i >= 0; i--) {
            if (cells[i][col].getBackground() == Color.BLACK) return false;
        }
        // Upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (cells[i][j].getBackground() == Color.BLACK) return false;
        }
        // Upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (cells[i][j].getBackground() == Color.BLACK) return false;
        }
        return true;
    }

    public void nQueens(int row) {
        if (row == n) {
            // Solution found! Flash the board or just stop
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(row, j)) {
                // VISUAL PLACE
                updateCell(row, j, Color.BLACK);
                sleep();

                nQueens(row + 1);

                // VISUAL BACKTRACK (Reset color)
                updateCell(row, j, (row + j) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                sleep();
            }
        }
    }

    private void updateCell(int r, int c, Color color) {
        // Swing is not thread-safe, so we use invokeLater to update the UI
        SwingUtilities.invokeLater(() -> cells[r][c].setBackground(color));
    }

    private void sleep() {
        try { Thread.sleep(DELAY); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static void main(String[] args) {
        // You can change '8' to any number you want to test!
        SwingUtilities.invokeLater(() -> new NQueensVisualizer(4));
    }
}