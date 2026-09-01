class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : nums){
            pq.add(num);
        }

        for(int i = 0; i<k; i++){
            ans = pq.remove();
        }

        return ans;
    }
}