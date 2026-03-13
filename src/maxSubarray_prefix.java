import java.util.*;

public class maxSubarray_prefix {

    public static int maxSubarray(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        // 1️⃣ Create prefix array
        int[] pre = new int[n];
        pre[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        // 2️⃣ Calculate max subarray sum using prefix array
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int sum;
                if (i == 0) {
                    sum = pre[j];
                } else {
                    sum = pre[j] - pre[i - 1];
                }

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 0,3 , 2 , 5};


        int res = maxSubarray(arr);
        System.out.println(res);
    }
}
