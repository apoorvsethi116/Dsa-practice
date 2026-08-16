class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hnew = new HashSet<>();

        for(int num : nums1){
            hs.add(num);
        }
        for(int num : nums2){
            if(hs.contains(num)){
                 hnew.add(num);
            }
           
        }

        int[] ans = new int[hnew.size()];
        int i = 0;

        for(int num : hnew){
            ans[i++] = num;
        }

        return ans;
    }
}