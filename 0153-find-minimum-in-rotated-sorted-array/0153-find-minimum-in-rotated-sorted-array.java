class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : nums){
            pq.add(a);
        }


        return pq.remove();
    }
}