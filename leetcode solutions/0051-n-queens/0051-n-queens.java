class Solution {

    public boolean isSafe(char[][] ans , int row , int col , int n){

        //up
        for(int i = row-1; i>=0; i--){
            if(ans[i][col] == 'Q'){
                return false;
            }
        }

        //upLeft
        for(int i = row-1 , j = col-1; i>=0 && j>=0; i--, j--){
            if(ans[i][j] == 'Q'){
                return false;
            }
        }

        //upRight
        for(int i = row-1 , j = col+1; i>=0 && j<n; i--, j++){
            if(ans[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void nQueen(char[][] ans , int n , int row , List<List<String>> res){

        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<n; i++){
                temp.add(new String(ans[i]));
            }
            res.add(temp);
            return;
        }

        for(int col = 0; col<n; col++){
            if(isSafe(ans , row , col , n)){
                ans[row][col] = 'Q';
                nQueen(ans ,n , row + 1 , res);
                ans[row][col] = '.';
            }

            
        }
    }
    public List<List<String>> solveNQueens(int n){
        char[][] ans = new char[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){

                ans[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        nQueen(ans , n , 0 , res);

        return res;
    }
}