class Solution {

    public void dfs(int[] candidates, int target, int currSum, int idx,
                    ArrayList<Integer> values,
                    ArrayList<ArrayList<Integer>> ans) {

        if (currSum == target) {
            ans.add(new ArrayList<>(values));
            return;
        }

        if (currSum > target || idx == candidates.length) {
            return;
        }

       
        values.add(candidates[idx]);
        dfs(candidates, target,
            currSum + candidates[idx], 
            idx + 1,
            values,
            ans);

        values.remove(values.size() - 1);

    
        while (idx + 1 < candidates.length &&
               candidates[idx] == candidates[idx + 1]) {
            idx++;
        }

        
        dfs(candidates, target,
            currSum,
            idx + 1,
            values,
            ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        dfs(candidates, target, 0, 0, values, ans);

        return new ArrayList<>(ans);
    }
}