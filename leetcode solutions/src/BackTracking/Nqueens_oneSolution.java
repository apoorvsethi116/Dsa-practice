package BackTracking;

public class Nqueens_oneSolution {
    static int count = 0;
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
        public static boolean nQueens(char[][] chess , int row){
            int n = chess.length;
            if(row == n){
                count++;
                //printBoard(chess , n);
                return true;
            }

            for(int j = 0; j<n; j++){
                if (isSafe(chess , row , j)){
                    chess[row][j] = 'Q';
                    if (nQueens(chess , row+1)){
                        return true;
                    }
                    chess[row][j] = 'x';
                }

            }
            return false;
        }
        public static void main(String[] args) {
            int n = 4;
            char[][] chess = new char[n][n];

            for(int i = 0; i < n; i++){
                for(int j =0; j< n; j++){
                    chess[i][j] = 'x';
                }
            }
            if (nQueens(chess , 0)){
                System.out.println("Solution is possible");
                printBoard(chess , n);
            }else{
                System.out.println("Solution is not possible");
            }


        }
    }


