package BackTracking;

public class Gridways {
    public static int fact(int n) {
        if (n <= 1) {
            return 1; // Base case
        }
        return n * fact(n - 1);
    }

    public static int optimalGridWays(int n , int m ){
//        using formula that for p repeatings chars
//        in n long string total permutations are
//        n! / p1! * p2! * .....
        int totalMoves = (n - 1) + (m - 1);
        int numerator = fact(totalMoves);
        int denominator = fact(n - 1) * fact(m - 1);

        return numerator / denominator;
    }
    public static int gridWays(int i , int j , int n , int m ) {
        if(i == n-1 && j == m-1){
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int w1 = gridWays(i+1 , j  , n , m);
        int w2 = gridWays(i , j+1 , n , m);

        return w1+ w2;
    }
    public static void main(String[] args) {
        int n = 3, m = 4;
//        System.out.println(gridWays(0 , 0 ,  n , m));
//        System.out.println(optimalGridWays(n , m));

        // Time Brute Force
        long start1 = System.nanoTime();
        int res1 = gridWays(0, 0, n, m);
        long end1 = System.nanoTime();

        // Time Optimal
        long start2 = System.nanoTime();
        int res2 = optimalGridWays(n, m);
        long end2 = System.nanoTime();

        System.out.println("--- Results for " + n + "x" + m + " Grid ---");
        System.out.println("Brute Force: " + res1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Optimal Math: " + res2 + " | Time: " + (end2 - start2) + " ns");
    }
}
