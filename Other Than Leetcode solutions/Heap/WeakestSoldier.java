package Heap;

import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class soldier implements Comparable<soldier>{
        int one;
        int rowIdx;

        public soldier(int one , int rowIdx){
            this.one = one;
            this.rowIdx = rowIdx;

        }

        @Override
        public int compareTo(soldier r2) {
            // Rule 1: Sort by soldier count ascending (Min-Heap style)
            if (this.one != r2.one) {
                return this.one - r2.one;
            }
            // Rule 2: If tied, smaller row index comes first
            return this.rowIdx - r2.rowIdx;
        }

    }

    public static void KweakestSoldier(int[][] arr , int k){
        PriorityQueue<soldier> pq = new PriorityQueue<>();

        for(int i  = 0; i< arr.length; i++){
            int count = 0;
            for(int j = 0; j<arr[0].length; j++){
                if(arr[i][j] == 1){
                    count++;
                }else{
                    break;
                }
            }

            pq.add(new soldier(count , i));
        }

        //print
        for(int a = 0; a<k; a++){
            int res = pq.remove().rowIdx;
            System.out.print("row " + res + " ");
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        int k = 2;

        KweakestSoldier(arr , k);

    }
}
