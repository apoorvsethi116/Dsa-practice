class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0){
            return false;
        }


        int[][] pos = new int[n*n][2];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }

        for(int i = 0; i<n*n - 1; i++){
            int r1 = pos[i][0];
            int c1 = pos[i][1];

            int r2 = pos[i+1][0];
            int c2 = pos[i+1][1];

            int dr = Math.abs(r1 - r2);
            int dc = Math.abs(c1 - c2);

            if(!((dr == 1 && dc == 2) || (dr == 2 && dc == 1))){
                return false;
            }
        }

        return true;
    }
}