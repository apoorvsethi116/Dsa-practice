package Recursion;

public class Tilling {
    public static int tilling(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical choice
        int fnm1 = tilling(n-1);

        //horizontal
        int fnm2 = tilling(n-2);

        //total ways
        int totWays = fnm1 + fnm2;
        return totWays;
    }
    public static void main(String[] args){
        // tile is 2 x 1 in size
        // floor is 2 x n
        int n = 4;
        System.out.println(tilling(n));
    }



}
