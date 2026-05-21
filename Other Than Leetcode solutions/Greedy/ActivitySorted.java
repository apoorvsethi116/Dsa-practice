package Greedy;

import java.util.ArrayList;

public class ActivitySorted {
    public static void main(String[] args) {
        int[] start = {1 , 3 , 0 , 5 , 8 , 5};
        int[] end = {2 , 4 , 6 , 7 , 9 ,9 };

        //we can store activites too
        ArrayList<String> a = new ArrayList<>();

        int max = 1;
        int prevEnd = end[0];
        a.add(start[0] +" " + end[0]);

        for(int i = 1; i < end.length; i++){
            if(start[i] >= prevEnd){
                a.add(start[i] + " " + end[i]);
                prevEnd = end[i];
                max++;
            }
        }
        System.out.println(max);
        System.out.println(a);
    }
}
