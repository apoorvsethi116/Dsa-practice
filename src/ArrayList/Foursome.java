package ArrayList;

import java.util.*;

public class Foursome {
    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // i moves forward
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            // j moves backward
            for (int j = n - 1; j > i + 2; j--) {
                if (j < n - 1 && nums.get(j).equals(nums.get(j + 1)))
                    continue;

                int k = i + 1;
                int l = j - 1;

                while (k < l) {
                    // Use .get() for ArrayLists and cast to long for overflow protection
                    long sum = (long)nums.get(i) + nums.get(j) + nums.get(k) + nums.get(l);

                    if (sum == target) {
                        // Create a temporary list of the 4 numbers and add it to ans
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(
                                nums.get(i), nums.get(k), nums.get(l), nums.get(j)
                        ));
                        ans.add(triplet);

                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while (k < l && nums.get(k).equals(nums.get(k - 1))) k++;
                        while (k < l && nums.get(l).equals(nums.get(l + 1))) l--;

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 0;
        // Easier way to initialize your list
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2));

        ArrayList<ArrayList<Integer>> res = fourSum(nums, target);
        System.out.println(res);
    }
}