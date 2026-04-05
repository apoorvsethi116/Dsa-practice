package BackTracking;

public class RatInMaze {
    public static boolean isSafe(int[][] maze , int res[][] , int row , int col , int n){
       if(row >=0 && col >= 0 && row < n && col < n &&
       maze[row][col] == 1 && res[row][col] == 0){
           return true;
       }else{
           return false;
       }
    }
    public static boolean ratSolve(int[][] maze ,int[][] res , int row , int col){
        int n = maze.length;
        if(row == n-1 && col == n-1){
            res[row][col] = 1;
            return true;
        }
        if(isSafe(maze , res , row , col , n)){
            res[row][col] = 1;

            if(ratSolve(maze , res , row , col+1)) return true;

            if(ratSolve(maze , res , row , col-1)) return true;

            if(ratSolve(maze , res , row+1 , col)) return true;

            if(ratSolve(maze , res , row-1 , col)) return true;

            res[row][col] = 0;//backtrack
            return false;
        }

        return false;



    }
    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int[][] res = new int[4][4];
        int n = maze.length;
        //initialize res[][]
        for(int i = 0; i < n; i++){
            for(int j =0; j< n; j++){
                res[i][j] = 0;
            }
        }

        ratSolve(maze , res , 0 , 0);

       //print
        for(int i = 0; i < n; i++){
            for(int j =0; j< n; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
