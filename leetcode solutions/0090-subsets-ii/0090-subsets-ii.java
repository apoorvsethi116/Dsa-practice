import java.util.*;

class Solution {

    public void helper(int[] nums, int idx, ArrayList<Integer> values, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(values));

        for (int i = idx; i < nums.length; i++) {

            
            if (i > idx && nums[i] == nums[i - 1]) continue;

            values.add(nums[i]);
            helper(nums, i + 1, values, ans);
            values.remove(values.size() - 1); 
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }
}