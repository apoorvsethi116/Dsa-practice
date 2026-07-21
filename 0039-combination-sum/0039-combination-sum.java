class Solution {

    public void dfs(int[] candidates ,int target , int idx , ArrayList<ArrayList<Integer>> ans , int currSum , ArrayList<Integer> values){
        if(currSum == target){
            ans.add(new ArrayList<Integer>(values));
            return;
        }

        if(currSum > target || idx == candidates.length){
            return;
        }

        values.add(candidates[idx]);
        dfs(candidates , target , idx , ans , currSum + candidates[idx] , values);


        //backtrack
        values.remove(values.size() - 1);

        dfs(candidates , target , idx + 1 , ans , currSum , values);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        dfs(candidates , target , 0 , ans , 0 , values);

        return new ArrayList<>(ans);
    }
}