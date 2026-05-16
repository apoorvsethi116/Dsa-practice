package Recursion;

public class TowerOfHanoi {
    public static void solveHanoi(int n, char src, char helper, char dest) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }

        // Step 1: Move n-1 disks from src to helper
        solveHanoi(n - 1, src, dest, helper);

        // Step 2: Move nth disk
        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        // Step 3: Move n-1 disks from helper to dest
        solveHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 3; // number of disks
        solveHanoi(n, 'A', 'B', 'C');
    }
}
