import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int[] med = new int[nums1.length + nums2.length];
        int a = 0;

        for (int i = 0; i < nums1.length; i++) {
            med[a] = nums1[i];
            a++;
        }

        for (int i = 0; i < nums2.length; i++) {
            med[a] = nums2[i]; 
            a++;
        }

        Arrays.sort(med);
        int mid = med.length / 2;

        if (med.length % 2 == 0) {
            int x = med[mid] + med[mid - 1];
            ans = x / 2.0; 
        } else {
            ans = med[mid];
        }

        return ans;
    }
}