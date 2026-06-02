package Greedy;

import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        Integer[] costH = {4 , 1 , 2};
        Integer[] costV = {2, 1, 3 ,1 ,4 };
        int n = 4 , m = 6;

        Arrays.sort(costH , Collections.reverseOrder());
        Arrays.sort(costV , Collections.reverseOrder());

        int h = 0; int v = 0;
        int hp = 1 , vp = 1;
        int cost = 0;

        while(h < n-1 && v < m-1){
            if(costH[h] >= costV[v]){
                cost += costH[h] * vp;
                h++;
                hp++;
            }else{
                cost += costV[v] * hp;
                v++;
                vp++;
            }
        }

        while(h < n-1){
            cost += costH[h] * vp;
            h++;
            hp++;
        }
        while(v < m-1){
            cost += costV[v] * hp;
            v++;
            vp++;
        }

        System.out.println("Minimum cost to cut : "  + cost);
    }
}
