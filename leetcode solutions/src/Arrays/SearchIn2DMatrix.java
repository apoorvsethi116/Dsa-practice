package Arrays;

//2 pointer approach
//coverted 2d index to 1d index and vise versa

public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = n*m-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            int r = mid/n;
            int c = mid%n;

            int midVal = matrix[r][c];

            if(midVal == target){
                return true;
            }else if(midVal<target){
                start = mid+1;

            }else{
                end = mid-1;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        //row major wise sorted matrix
           int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
           };
    }
}
