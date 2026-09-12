class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        for(int a: nums){
            hs.add(a);
        }
        int i = 0;
        for(int b : hs){
            nums[i] = b;
            i++;
        }

        return hs.size();
    }
}