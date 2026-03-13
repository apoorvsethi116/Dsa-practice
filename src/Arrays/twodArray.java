package Arrays;

import java.util.*;
public class twodArray {
    public static void main(String args[]){
        int matrix[][] = new int[2][3];
       //int[][] matrix = new int[2][3]; can be written like this also
        int n = matrix.length;
        int m = matrix[0].length;
        Scanner sc = new Scanner(System.in);

        //input
        for(int i = 0; i<n; i++){
            for (int j = 0; j < m; j++) {
                 matrix[i][j] = sc.nextInt();

            }
        }
        //print
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }
        //search
        System.out.println("Enter num to find : ");
        int target = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == target){
                    System.out.println("found");
                    break;
                }
            }

        }


        //System.out.println(n);
    }

}
