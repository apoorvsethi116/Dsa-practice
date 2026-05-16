package ArrayList;
import java.util.*;
public class PairSum {
    public static ArrayList<Integer> pairSum(int[] arr , int target){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if(n==1){
            return ans;
        }
        int pivot = 0;
        for (int i = 0; i < n-1; i++) {
            if(arr[i] < arr[i+1]) {
                pivot = i;
            }
        }

        int i = pivot + 1;
        int j = pivot;

        while(i != j){
            int currentSum = arr[i] + arr[j];
            if(currentSum == target){
                ans.add(arr[i]);
                ans.add(arr[j]);
            }
            //modular Airthematic
            if (currentSum < target) {
                // Move smallest pointer forward circularly
                i = (i + 1) % n;
            } else {
                // Move largest pointer backward circularly
                j = (n + j - 1) % n;
            }
        }

        return ans;


    }
    public static void main(String[] args) {
        int target = 4;
        //sorted rotated array
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(pairSum(arr , target));
    }
}
