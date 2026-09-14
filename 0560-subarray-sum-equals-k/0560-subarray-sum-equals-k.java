class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        //map : sum , count
        int sum = 0;
        map.put(0 , 1);
        int count = 0;

        for(int a : nums){
            sum += a;

            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }

            map.put(sum , map.getOrDefault(sum , 0) +1);
        }

       return count;
    }
}