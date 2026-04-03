package BackTracking;

public class Nqueens {
    public static boolean isSafe(char[][] chess ,int row , int col){
        //up
        for(int i = row-1; i>=0; i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //upleft
        for(int i = row-1 , j = col-1; i>=0 && j>=0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //upright
        for(int i = row-1 , j = col+1; i>=0 && j<chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public static void printBoard(char chess[][] , int n){
        System.out.println("----------chess-----------");
        for(int i = 0; i < n; i++){
            for(int j =0; j< n; j++){
                System.out.print( chess[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void nQueens(char[][] chess , int row){
        int n = chess.length;
        if(row == n){
            printBoard(chess , n);
            return;
        }

        for(int j = 0; j<n; j++){
            if (isSafe(chess , row , j)){
                chess[row][j] = 'Q';
                nQueens(chess , row+1);
                chess[row][j] = 'x';
            }

        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] chess = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j =0; j< n; j++){
                chess[i][j] = 'x';
            }
        }
        nQueens(chess , 0);
    }
}
