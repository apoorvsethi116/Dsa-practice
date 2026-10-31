class Solution {
    public void rec(int idx , int target , ArrayList<Integer> a , List<List<Integer>> ans , int[] og){
       
        if(target == 0){
            ans.add(new ArrayList<>(a));
            return;
        }
         if(idx == og.length){
            return;
        }
        //pick
        if(og[idx] <= target){
            a.add(og[idx]);
            rec(idx , target-og[idx] , a , ans , og);


            a.remove(a.size() - 1);
        }//not pick
            
        rec(idx+1 , target , a , ans , og);
        

       
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        rec(0 , target , new ArrayList<Integer>() , ans , candidates);


        return ans;
    }
}