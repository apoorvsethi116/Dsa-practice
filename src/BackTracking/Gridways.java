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
        System.out.println(gridWays(0 , 0 ,  n , m));
        System.out.println(optimalGridWays(n , m));
    }
}
