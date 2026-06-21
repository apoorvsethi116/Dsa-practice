package Heap;
import java.util.*;

public class N_Ropes {
    public static int minCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            pq.add(arr[i]);
        }

        int total = 0;

        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();

            int curr = first + second;
            total += curr;

            pq.add(curr);
        }

        return total;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        System.out.println(minCost(arr));
    }
}
