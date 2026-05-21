package Greedy;

import java.util.*;

public class ActivityUnsorted {
    public static void main(String[] args) {
        int[] start = {1 , 3 , 0 , 5 , 8 , 5};
        int[] end = {6 , 9 , 2 , 7 , 4 ,9 };

        //sorting
        int[][] activites = new int[start.length][3];
        for(int i = 0; i < activites.length; i++){
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }

        Arrays.sort(activites , Comparator.comparingDouble(o -> o[2]));//sorted accordin to end time
        int max = 1;
        int prevEnd = activites[0][2];

        for(int i = 1; i < activites.length; i++){
            if(activites[i][1] >= prevEnd){
                prevEnd = activites[i][2];
                max++;
            }
        }
        System.out.println(max);
    }
}
