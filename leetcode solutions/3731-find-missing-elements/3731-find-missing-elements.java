class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            hs.add(i);
        }
        for (int num : nums) {
            hs.remove(num);
        }
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if (hs.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}