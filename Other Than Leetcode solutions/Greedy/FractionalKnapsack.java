package Greedy;
import java.util.*;
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = {60, 120, 100, 40};
        int[] weight = {10, 30, 20, 10};
        int W = 50;
        int maxValue = 0;

        double[][] temp = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            temp[i][0] = i;
            temp[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(temp, Comparator.comparingDouble(o -> o[1]));

        for (int i = temp.length - 1; i >= 0; i--) {
            if (weight[(int) temp[i][0]] <= W) {
                maxValue += value[(int) temp[i][0]];
                W = W - weight[(int) temp[i][0]];
            }else{
                maxValue += (temp[i][1] * W);
                W = 0;
                break;
            }
        }
        System.out.println(maxValue);
    }
}